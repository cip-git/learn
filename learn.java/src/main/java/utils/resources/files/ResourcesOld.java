package utils.resources.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static utils.resources.files.ResourcesOld.Create.SrcMainResources.createFile;
import static utils.resources.files.Separation.FILE_SEPARATOR;

public interface ResourcesOld {
    String IBM_CTANASE = "AzureAD\\CiprianDorinTanase";
    String USER = IBM_CTANASE;
    String DOT_PROPERTIES = ".properties";
    String SRC_MAIN_JAVA = "src.main.java";
    String SRC_MAIN_RESOURCES = "src.main.resources";
    String SRC_MAIN_RESOURCES_DB = "src.main.resources.db";

    Comparator <Path> COMPARE_BY_DISTANCE_FROM_SOURCE = comparingInt(Path::getNameCount);
    BiPredicate <Path, Path> IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            System.err.println("Resources.IS_SAME_FILE.apply(" + p + ", " + p2 + ")");
        }
        return false;
    };

    Consumer <Path> DELETE_IF_EXISTS = p -> {
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            System.err.println("Resources.DELETE_IF_EXISTS.apply(" + p + ")");
        }
    };

    static void clean() {
        Path path = Paths.get(FILE_SEPARATOR.separationOf(SRC_MAIN_RESOURCES));
        deleteFrom(path);
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

    interface LocationOf {
        interface SrcMainResources {

            static String dir(final Package pkg) {
                return FILE_SEPARATOR.separationOf(SRC_MAIN_RESOURCES) + File.separator + FILE_SEPARATOR.separationOf(pkg.getName());
            }
        }

        interface PropertyResourceBundle {

            static String bundle(Package pkg, String prop) {
                return FILE_SEPARATOR.separationOf(pkg.getName()) + File.separator + prop;
            }
        }

        interface ListResourceBundle {

            static String bundle(Package pkg, String name) {
                return pkg.getName() + "." + name;
            }
        }
    }

    interface Create {

        interface PropertyResourceBundle {

            static Path bundle(Package pkg, String name) {
                return createFile(pkg, name + DOT_PROPERTIES);
            }
        }

        interface SrcMainResources {

            static Path createDirectories(final Package pkg) {
                Path path = Paths.get(FILE_SEPARATOR.separationOf(SRC_MAIN_RESOURCES), FILE_SEPARATOR.separationOf(pkg.getName()));
                try {
                    path = Files.createDirectories(path);
                } catch (IOException e) {
                    System.err.println(String.format("Resources.Create.SrcMainResources.createDirectories(%s)", pkg.getName()));
                }
                return path;
            }

            static Path createFile(Package pkg, String name) {
                Path dir = createDirectories(pkg);
                Path file = Paths.get(dir.toString(), name);
                if (!Files.exists(file)) {
                    try {
                        file = Files.createFile(file);
                    } catch (IOException e) {
                        System.err.println(String.format("Resources.Create.SrcMainResources.createFile(%s, %s)",
                                pkg.getName(), name));
                    }
                }
                return file;
            }
        }

        interface Populate {
            interface SrcMainResources {
                static Path file(Package pkg, String name) {
                    Path path = createFile(pkg, name);
                    return ResourcesOld.Populate.file(path);
                }
            }
        }
    }

    interface Populate {
        int NR_OF_LINES = 007;

        static String content() {
            return IntStream.rangeClosed(1, NR_OF_LINES)
                    .mapToObj(i -> "Line nr " + i + "\n")
                    .collect(StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append).toString();
        }

        static Path file(Path path) {
            try (BufferedWriter bw = Files.newBufferedWriter(path)) {
                bw.write(content());
            } catch (IOException e) {
                System.err.println(String.format("Resources.Populate.file(%s)", path.toString()));
            }
            return path;
        }
    }
}
