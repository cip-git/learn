package oc.p._8._8_IO.tw.review.q._21;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Run {
    Path base = ResourcesOld.Create.SrcMainResources.createDirectories(this.getClass().getPackage());
    Path p = Paths.get(base.toString(), "p");

    void write() throws IOException {
        p = Files.createFile(p);
        try(FileOutputStream fos = new FileOutputStream(p.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos)){
            oos.writeObject(new Zebra());
        }
    }

    void read() throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(p.toFile());
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis)){
            Zebra z = (Zebra)ois.readObject();
            System.out.println(z.getName());
            System.out.println(z.getAge());
            System.out.println(z.getTail());
            System.out.println(z.getFriends());
            System.out.println(Zebra.getBirthPlace());
            System.out.println(Zebra.getLongSerialUID());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Run r = new Run();
//        r.write();
        r.read();
    }
}
