package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import utils.print.Print;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class Write {

    void writeA() throws IOException {
        Path p = Files.createFile(Run.A);
        try (FileOutputStream fos = new FileOutputStream(p.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(new A());
        }
        Print.Delimitators.equal();
    }

    void writeB() throws IOException {
        Path p = Files.createFile(Run.B);
        try (FileOutputStream fos = new FileOutputStream(p.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(new B());
        }
        Print.Delimitators.equal();
    }

    void writeC() throws IOException {
        Path p = Files.createFile(Run.C);
        try (FileOutputStream fos = new FileOutputStream(p.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(new C());
        }
        Print.Delimitators.equal();
    }

    void write() throws IOException {
        writeA();
        writeB();
        writeC();
    }
}
