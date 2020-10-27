package oc.p._8._9_NIO2.util;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static utils.resources.files.Separation.FILE_SEPARATOR;

public class TestPath {

    public static Path EMPTY_PATH = Paths.get("");
    public static Path WORKING_DIR = Paths.get("").toAbsolutePath();

    public static Path RELATIVE_LINUX_PATH = Paths.get("zoo/vertebarte/lion");
    public static Path ABSOLUTE_LINUX_PATH = Paths.get("/zoo/vertebrate/lion");

    public static Path RELATIVE_WINDOWS_PATH = Paths.get("zoo\\vertebrate\\lion");
    public static Path ABSOLUTE_WINDOWS_PATH =
            Paths.get(ResourcesOld.Create.SrcMainResources.createFile(new TestPath().getClass().getPackage(),
                    "aWP").toAbsolutePath().toString());


    static Path SRC_MAIN_JAVA = Paths.get(FILE_SEPARATOR.separationOf(ResourcesOld.SRC_MAIN_JAVA));
    static Instant THIS_YEAR = Instant.now().minus(LocalDateTime.now().getDayOfYear() - 1, ChronoUnit.DAYS);
    static Instant THIS_MONTH = Instant.now().minus(LocalDateTime.now().getDayOfMonth() - 1, ChronoUnit.DAYS);

    public static Map <String, Path> map() {
        Map <String, Path> map = new LinkedHashMap <>();

        map.put("EMPTY_PATH", EMPTY_PATH);
        map.put("WORKING_DIR", WORKING_DIR);
        map.put("RELATIVE_LINUX_PATH", RELATIVE_LINUX_PATH);
        map.put("ABSOLUTE_LINUX_PATH", ABSOLUTE_LINUX_PATH);
        map.put("RELATIVE_WINDOWS_PATH", RELATIVE_WINDOWS_PATH);
        map.put("ABSOLUTE_WINDOWS_PATH", ABSOLUTE_WINDOWS_PATH);
        return map;
    }

    public static Stream <Path> pathsThisYear() {
        return getPathStream(THIS_YEAR);
    }

    public static Stream <Path> pathsThisMonth() {
        return getPathStream(THIS_MONTH);
    }

    public static Stream <Path> allPaths() {
        try {
            return Files.walk(Paths.get(FILE_SEPARATOR.separationOf(ResourcesOld.SRC_MAIN_JAVA)));
        } catch (IOException e) {
            return null;
        }
    }

    private static Stream <Path> getPathStream(Instant thisYear) {
        try {
            return Files.find(SRC_MAIN_JAVA, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(thisYear));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
