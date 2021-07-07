package iq.pentalog;

import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Prepare {

    Path inputPath;

    {
        final var pkg = this.getClass().getPackage();
        final var src = List.of("src", "main", "java");
        final var name = Arrays.asList(pkg.getName().split("\\."));
        final var input = List.of("input.txt");

        final var strings = Stream
                .of(src, name, input)
                .flatMap(List::stream)
                .collect(toList())
                .toArray(new String[0]);
        inputPath = Path.of(strings[0], Arrays.copyOfRange(strings, 1, strings.length));
    }

    public static void main(String[] args) {
        final var run = new Prepare();
//        run.prepare();
        run.concatenateLyrics();
    }


    void concatenateLyrics() {
        try {
            final var list = Files.readAllLines(inputPath);
            concatenateLyrics(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void concatenateLyrics(List<String> list) {
        final Deque<String> que = new ArrayDeque<>();
        final var strophes = new ArrayList<List<String>>();
        var lyrics = new ArrayList<String>();

        for (var line : list) {

            if(line.length() == 0){
                strophes.add(lyrics);
                lyrics = new ArrayList<>();
                continue;
            }

            if (line.startsWith("\"")) {
                que.clear();
            }

            if (line.startsWith(",")) {
                Optional
                        .ofNullable(que.pollLast())
                        .map(s -> s.trim())
                        .ifPresent(que::add);
            }

            que.add(line.trim());

            if (line.endsWith("\"")) {
                lyrics.add(que.stream().collect(Collectors.joining()));
            } else {
                if (line.startsWith("\"")) {
                    que.add(" ");
                }
            }

        }

        strophes.forEach(l-> {
            l.forEach(System.out::println);
            System.out.println();
        });
    }

    void prepare() {
        System.out.println(inputPath);
        try (final var writer = Files.newBufferedWriter(inputPath, WRITE)) {
            final var list = Files.readAllLines(inputPath);
            for (var line : list) {
                if (line.length() > 1) {
                    writer.write("\"" + line + "\"");
                }
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
