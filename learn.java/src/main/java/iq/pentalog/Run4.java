package iq.pentalog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import utils.print.Print;

class Run4 {

    private Path inputPath;
    private Path outputPath;

    {
        inputPath = Path.of("src", "main", "java", "iq", "pentalog", "input.txt");
        outputPath = Path.of("src", "main", "java", "iq", "pentalog", "output.txt");
    }

    public static void main(String[] args) throws IOException {
        final var run = new Run4();
        run.lyrics();
    }

    List<String> lyrics() throws IOException {
        final var builder = new StringBuilder();
        final var map = new HashMap<String, Integer>();

        Files
                .readAllLines(inputPath)
                .forEach(line -> addLine(builder, map, line));

        final var res = map
                .entrySet()
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        Map.Entry::getValue,
                        ConcurrentSkipListMap::new,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList())));

        Print.print(res);

        return res
                .lastEntry()
                .getValue();
    }

    private void addLine(StringBuilder builder, Map<String, Integer> map, String line) {
        if (line.startsWith("\"")) {
            builder.delete(0, builder.length());
        }

        builder.append(line.trim()).append(" ");

        if (line.endsWith("\"")) {
            map.merge(
                    builder
                            .toString()
                            .replace(" ,", ",")
                            .replace("  ", " "),
                    1,
                    (o, n) -> o + n);
        }
    }


}
