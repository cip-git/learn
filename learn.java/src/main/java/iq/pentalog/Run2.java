package iq.pentalog;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import utils.print.Print;

class Run2 {

    private final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
    private Path inputPath;
    private Path outputPath;

    {
        inputPath = Path.of("src", "main", "java", "iq", "pentalog", "input.txt");
        outputPath = Path.of("src", "main", "java", "iq", "pentalog", "output.txt");
    }

    public static void main(String[] args) {
        final var run = new Run2();
        run.work();
    }

    void work() {
        ExecutorService exec = null;
        try {
            final var list = Files.readAllLines(inputPath);

            exec = Executors.newCachedThreadPool();
            final var strophes = strophes(list);
            final var cyclicBarrier = new CyclicBarrier(strophes.size(), () -> {
                final var descendingMap = map
                        .entrySet()
                        .parallelStream()
                        .collect(Collectors.groupingByConcurrent(Map.Entry::getValue, ConcurrentSkipListMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                        .descendingMap();
                Print.print(descendingMap);

                final var value = descendingMap.firstEntry().getValue();
                System.out.println(value);
            });

            strophes
                    .stream()
                    .map(l -> new Worker(l, cyclicBarrier))
                    .forEach(exec::submit);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    private List<List<String>> strophes(List<String> list) {
        final Deque<String> que = new ArrayDeque<>();
        final var strophes = new ArrayList<List<String>>();
        var lyrics = new ArrayList<String>();

        for (var line : list) {

            if (line.length() == 0) {
                strophes.add(lyrics);
                lyrics = new ArrayList<>();
                continue;
            }

            if (line.startsWith("\"")) {
                que.clear();
            }

            que.add(line.trim());

            if (line.endsWith("\"")) {
                lyrics.add(que.stream().collect(joining(" ")).replace(" ,", ","));
            }
        }

        write(strophes);
        return strophes;
    }

    private void write(List<List<String>> strophes) {
        try (final var writer = Files.newBufferedWriter(outputPath, StandardOpenOption.WRITE)) {
            for (var strophe : strophes) {
                for (var line : strophe) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Worker implements Runnable {
        private final List<String> strophe;
        private final CyclicBarrier cyclicBarrier;

        public Worker(List<String> strophe, CyclicBarrier cyclicBarrier) {
            this.strophe = strophe;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                strophe.forEach(line -> map.merge(line, 1, (o, n) -> o + n));
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
