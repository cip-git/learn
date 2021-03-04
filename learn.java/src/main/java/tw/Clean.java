package tw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class Clean {

    static void m() throws IOException {
        final Path path = Path.of("src", "main", "resources", "a.txt");

        final List<String> list = Files.readAllLines(path);

        final long count = list
                .stream()
                .filter(line -> line.contains("EVENT: "))
                .peek(System.out::println)
                .count();

        System.out.println("COUNT: " + count);

        list
                .stream()
                .filter(line -> line.contains("EVENT: "))
                .collect(Collectors.groupingBy(s -> s.split("key=")[1].split(",")[0], Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " -> " + v));

    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
