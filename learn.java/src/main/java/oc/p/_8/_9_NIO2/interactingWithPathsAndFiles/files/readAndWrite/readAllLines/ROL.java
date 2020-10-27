package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.readAndWrite.readAllLines;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Read all lines from a file.
 *
 * static List<String> readAllLines(Path path) throws IOException
 *
 * static List<String> readAllLines(Path path, Charset cs) throws IOException
 */
class ROL {

    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "p");

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();

        new ROL().rol();
    }

    void rol() throws IOException {
        List <String> lst = Files.readAllLines(path);

        lst.forEach(System.out::println);
    }
}
