package utils.resources.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface Get {

    Stream<Path> get();

    default Stream<Path> get(Path root){

        System.out.println("Root: " + root + "\n");
        try {
            return Files
                    .find(root, Byte.MAX_VALUE, (p, bfa) -> !bfa.isSymbolicLink());
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Exception on get");
    }
}
