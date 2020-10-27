package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Run {

    static Path BASE = ResourcesOld.Create.SrcMainResources.createDirectories(new Run().getClass().getPackage());
    static Path A = Paths.get(BASE.toString(), "a");
    static Path B = Paths.get(BASE.toString(), "b");
    static Path C = Paths.get(BASE.toString(), "c");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Run r = new Run();
//        r.write();
        r.read();
    }

    void write() throws IOException {
        new Write().write();
    }

    void read() throws IOException, ClassNotFoundException {
        final Read read = new Read();
        read.read();
//        read.readC();
    }
}
