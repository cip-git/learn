package oc.p._8._8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj;

import utils.print.Print;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static utils.resources.files.ResourcesOld.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.FILE_SEPARATOR;

class Create {

    String pkg = this.getClass().getPackage().getName();
    File dir;

    {
        dir = new File(FILE_SEPARATOR.separationOf(SRC_MAIN_RESOURCES) + File.separator, FILE_SEPARATOR.separationOf(pkg));
        System.out.println(dir);
        System.out.println(dir.mkdir());  //false
        System.out.println(dir.mkdirs());  //true

        Print.Delimitators.equal();

        File file = new File(dir, this.getClass().getSimpleName());

        m(file);  //true

        write(file);
        read(file);

        m(file);  //false; the file already exists


    }

    public static void main(String[] args) {
        new Create();
    }

    private void read(final File file) {
        try (FileReader fr = new FileReader(file)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void write(final File file) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("this is a String");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void m(final File file) {
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
