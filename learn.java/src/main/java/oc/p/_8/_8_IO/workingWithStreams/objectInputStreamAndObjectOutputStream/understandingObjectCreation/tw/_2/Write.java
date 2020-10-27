package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;

import utils.print.Print;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class Write {


    void writeB() throws IOException {
        Path b = Files.createFile(Run.B);

        try (FileOutputStream fos = new FileOutputStream(b.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(new B());
        }
        Print.Delimitators.equal();
    }


    void writeC() throws IOException {
        Path c = Files.createFile(Run.C);

        try (FileOutputStream fos = new FileOutputStream(c.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(new C());
        }
        Print.Delimitators.equal();
    }

    void write() throws IOException {
        writeB();
        writeC();
    }

}
