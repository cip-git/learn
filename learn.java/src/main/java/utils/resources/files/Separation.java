package utils.resources.files;

import java.io.File;

@FunctionalInterface
public interface Separation {

    Separation FILE_SEPARATOR = s -> s.replace(".", File.separator);
    Separation DOT = s -> s.replace(String.valueOf(File.separator), ".");

    String separationOf(String s);
}
