package oc.p._11._8_IO.Review_Questions.qs._22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class R {

    File root = new File("src/main/resources/root");
    File file = new File(root, "file");

    {
        root.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Zebra implements Serializable {
    private static String birthPlace = "Africa";
    List<Zebra> friends = new ArrayList<>();
    private transient String name = "George";
    private transient Integer age;
    private Object stripes = new Object();

    {
        age = 10;
    }

    public Zebra() {
        this.name = "Sophia";
    }

    static Zebra writeAndRead(File f, Zebra z) {
        try (
                final var oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))
        ) {
            oos.writeObject(z);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(
                final var ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))
        ) {
            while (true) {
                final Object o = ois.readObject();
                return (Zebra)o;
            }
        }catch (EOFException eof){
            eof.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        final R r = new R();
        var zebra = new Zebra();
        zebra  = writeAndRead(r.file, zebra);
        System.out.println(zebra);
    }
}