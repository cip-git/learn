package oc.p._8._9_NIO2.presentingNewStreamMethods.walkingADirectory.listingADirectorry;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.ResourcesOld.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.FILE_SEPARATOR;

/**
 * static Stream<Path>	list(Path dir) Return a lazily populated Stream,
 * the elements of which are the entries in the directory. The listing is not recursive
 */
class List {

    Path path = Paths.get(FILE_SEPARATOR.separationOf(SRC_MAIN_JAVA));

    public static void main(String[] args) throws IOException {
        List l = new List();

//        l.m();
        l.m2();
    }

    void m() throws IOException {
        Files.list(path).
                forEach(System.out::println);
    }

    void m2() throws IOException {
        Path path = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "f");
        Files.list(path)
            .forEach(System.out::println);  // IOException
    }
}
