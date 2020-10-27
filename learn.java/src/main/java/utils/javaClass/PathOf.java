package utils.javaClass;

import java.nio.file.Path;

import utils.resources.files.Location;

public enum PathOf {

    SRC_MAIN_JAVA(Path.of(Location.SRC_MAIN_JAVA.asPath())),

    SRC_MAIN_JAVA_GTK(Path.of(Location.SRC_MAIN_JAVA.asPath(), "gtk"));

    private Path value;

    PathOf(Path value) {
        this.value = value;
    }

    public Path getValue() {
        return value;
    }
}
