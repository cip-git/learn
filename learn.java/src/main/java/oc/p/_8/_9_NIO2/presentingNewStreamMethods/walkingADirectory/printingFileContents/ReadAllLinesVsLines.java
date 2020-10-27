package oc.p._8._9_NIO2.presentingNewStreamMethods.walkingADirectory.printingFileContents;

import utils.delimitators.Delimitators;
import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

class ReadAllLinesVsLines {

    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "file");

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        ReadAllLinesVsLines r = new ReadAllLinesVsLines();

        r.readAllLines();
        Delimitators.equal();
        r.lines();
    }

    void readAllLines() throws IOException {
        List <String> lst = Files.readAllLines(path);
        lst.forEach(System.out::println);
    }

    void lines() throws IOException {
        Stream <String> stream = Files.lines(path);
        stream.forEach(System.out::println);
    }
}
