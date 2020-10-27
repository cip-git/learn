package utils.resources.src;

import java.nio.file.Path;
import java.util.stream.Stream;


public enum Src {
    ;

    public enum Main implements Location, Get {

        JAVA {
            @Override
            public Path path() {
                return Path.of("src", "main", "java");
            }
        },
        RESOURCES {
            @Override
            public Path path() {
                return Path.of("src", "main", "resources");
            }
        };

        @Override
        public Stream<Path> get() {
            return get(path());
        }
    }

    public enum Test {
        ;

        public enum Java {

        }

        public enum Resources {

        }
    }
}




