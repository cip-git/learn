package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.serializableInterface;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.util.Arrays;

class RunAnimal {

    File file;

    {
        file = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "cat.txt").toFile();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RunAnimal r = new RunAnimal();
        r.write();
        r.read();

        ResourcesOld.clean();
}

    void write() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            String name = "a";
            Arrays.stream(Type.values()).forEach(t -> {
                char c = 'a';
                for(int i=0; i<t.ordinal(); i++){
                    c++;
                }
                Animal a = new Animal(name + t.ordinal(), t.ordinal(), t, c);

                try {
                    oos.writeObject(a);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    void read() throws ClassNotFoundException, IOException {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object o;
            while(true) {
                o = ois.readObject();
                if(o instanceof Animal) {
                    Animal a = (Animal) o;
                    System.out.println(a);
                }
            }
        } catch(EOFException e) {
            /**
             * Acceptable way to exit
             */
//            e.printStackTrace();
        }
    }

}

