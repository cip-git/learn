package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import utils.print.Print;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class Read {

    void readA() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(Run.A.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            ois.readObject();
            Print.Delimitators.equal();
        }
    }

    void readB() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(Run.B.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            ois.readObject();
            Print.Delimitators.equal();
        }
    }

    void readC() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(Run.C.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            ois.readObject();
            Print.Delimitators.equal();
        }
    }

    void read() throws IOException, ClassNotFoundException {
        readA();
        readB();
        readC();
    }
}
