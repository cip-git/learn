package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Run {

    static Path BASE = ResourcesOld.Create.SrcMainResources.createDirectories(new Run().getClass().getPackage());
    static Path B = Paths.get(BASE.toString(), "b");
    static Path C = Paths.get(BASE.toString(), "c");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Resources.clean();
        Run r = new Run();
//        r.write();
        r.read();

    }

    void read() throws IOException, ClassNotFoundException {
        Read r = new Read();
        r.read();
    }

    void write() throws IOException {
        Write w = new Write();
        w.write();
    }
}
