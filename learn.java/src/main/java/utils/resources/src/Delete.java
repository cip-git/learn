package utils.resources.src;

import static java.util.Comparator.comparingInt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

class Delete {
    static Consumer<Path> DELETE_IF_EXISTS = p -> {
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            System.err.println("Resources.DELETE_IF_EXISTS.apply(" + p + ")");
        }
    };
    static Comparator<Path> COMPARE_BY_DISTANCE_FROM_SOURCE = comparingInt(Path::getNameCount);
    static BiPredicate<Path, Path> IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            System.err.println("Resources.IS_SAME_FILE.apply(" + p + ", " + p2 + ")");
        }
        return false;
    };

    static void clean(String base) {
        deleteFrom(Path.of(base));
    }

    static void deleteFrom(Path path) {
        try {
            Files.walk(path)
                    .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
                    .filter(p -> IS_SAME_FILE.negate().test(p, path))
                    .forEach(DELETE_IF_EXISTS);
        } catch (IOException e) {
            System.err.println("Resources.deleteFrom(" + path + ")");
        }
    }
}
