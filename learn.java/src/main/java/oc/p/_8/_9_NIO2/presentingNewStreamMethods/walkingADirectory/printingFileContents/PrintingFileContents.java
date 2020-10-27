package oc.p._8._9_NIO2.presentingNewStreamMethods.walkingADirectory.printingFileContents;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * static Stream<String> lines(Path path)
 *
 * static Stream<String> lines(Path path, Charset cs)
 *
 */
class PrintingFileContents {

    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(),
            this.getClass().getSimpleName());

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        PrintingFileContents pfc = new PrintingFileContents();

        pfc.m();
    }

    void m() throws IOException {
        Files.lines(path)
                .forEach(System.out::println);
    }
}
