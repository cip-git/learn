package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;

import utils.print.Print;

import java.io.*;

class Read {

    void readB() throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(Run.B.toFile());
        BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)){
//            ois.readObject();
            Object o = ois.readObject();
            Print.Delimitators.equal();
        }
    }

    void readC() throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(Run.C.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)){
            Object o = ois.readObject();
            Print.Delimitators.equal();
        }
    }

    void read() throws IOException, ClassNotFoundException {
        readB();
        readC();
    }
}