package oc.p._8._8_IO.tw.review.q._16;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Run {

    Path base = ResourcesOld.Create.SrcMainResources.createDirectories(this.getClass().getPackage());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ResourcesOld.clean();

        Run r = new Run();
//        r.ns();
        r.s();
    }

    void ns() throws IOException, ClassNotFoundException {
        Path p = Files.createFile(Paths.get(base.toString(), "ns"));
        NS ns = new NS(1);
        NS ns2 = new NS(2);

        try (FileOutputStream fos = new FileOutputStream(p.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ns);
            oos.writeObject(ns2);
        }

        try (FileInputStream fis = new FileInputStream(p.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            ois.readObject();
            ois.readObject();
        }
    }

    void s() throws IOException, ClassNotFoundException {
        Path p = Files.createFile(Paths.get(base.toString(), "ns"));
        S s = new S(1);
        S s2 = new S(2);

        try (FileOutputStream fos = new FileOutputStream(p.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(s);
            oos.writeObject(s2);
        }

        try (FileInputStream fis = new FileInputStream(p.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            ois.readObject();
            ois.readObject();
        }
    }
}
