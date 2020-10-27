package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.isSameFile;

import utils.resources.files.ResourcesOld;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * static boolean	isSameFile(Path file, Path path2) throws IOException
 *
 * Tests if two paths locate the same file.
 *
 * This isSameFile() method does not compare the contents of the file. For
 * example, two files may have identical content and attributes, but if they
 * are in different locations, then this method will return false .
 */
class IsSameFile {
    Package pkg = getClass().getPackage();

    Path from = ResourcesOld.Create.Populate.SrcMainResources.file(pkg, "from");
    Path to = ResourcesOld.Create.SrcMainResources.createFile(pkg, "to");

    void m() throws IOException {
        to = Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

        boolean b = Files.isSameFile(from, to);
        System.out.println(b);  //false
    }

    void m2() throws IOException {
        Path dir =  Paths.get(from.getParent().toString(), "dir");
        dir = Files.createDirectories(dir);
        Path link = Paths.get(dir.toString(), "link");
        link = Files.createLink(link, from);

        System.out.println(Files.isSameFile(from, link));  //true
    }

    void m3() throws IOException {
        Path p = Paths.get(ResourcesOld.LocationOf.SrcMainResources.dir(pkg), "m3");
        System.out.println(Files.isSameFile(from, p));
    }

    void m4() throws IOException {
        Path p = Paths.get("m4");
        System.out.println(Files.isSameFile(from, p));
    }

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        IsSameFile isf = new IsSameFile();

//        isf.m();
//        isf.m2();
        isf.m3();
//        isf.m4();
    }
}
