package oc.p._8._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.methods;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.File;
import java.io.IOException;

import static utils.resources.files.ResourcesOld.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.FILE_SEPARATOR;

class Test {

    static File dir = new File(FILE_SEPARATOR.separationOf(SRC_MAIN_RESOURCES) + File.separator + FILE_SEPARATOR.separationOf(new Test().getClass().getPackage().getName()));
    static File file = new File(dir.getPath(), "file");
    static File file2 = new File(FILE_SEPARATOR.separationOf(ResourcesOld.SRC_MAIN_RESOURCES) + File.separator + "file");

    static {
        System.out.println("dir creation: " + dir.mkdirs());
        try {
            System.out.println("file creation: " + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Print.Delimitators.equal();
    }


    static void m() {
        System.out.println(dir);
        System.out.println(dir.getPath());
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.toPath());
    }

    public static void main(String[] args) {
        m();
        ResourcesOld.clean();
    }
}
