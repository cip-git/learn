package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.create.dir;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException
 *
 * static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException
 */
class Create {
    static String location = ResourcesOld.LocationOf.SrcMainResources.dir(new Create().getClass().getPackage());


    void createDirectories(){
        Path p = null;
        try {
            p = Files.createDirectories(Paths.get(location));
            System.out.println(Files.exists(p));
        } catch (IOException e) {
            System.out.println("Err on createDirectories");
        }
    }

    void createDirectory(){
        try {
            Path p = Files.createDirectory(Paths.get(location, "newDir"));
            System.out.println(Files.exists(p));
        } catch (IOException e) {
            System.out.println("Err on creating existing directory");
        }
    }

    void createDirWhenNameAlreadyExists(){
        String name = "bla";
        try {
            Path p = Files.createFile(Paths.get(location, name));
            System.out.println(Files.exists(p));
        } catch (IOException e) {
            System.out.println("Err on createFile");
        }

        try {
            Path p2 = Files.createDirectory(Paths.get(location, name));
        } catch (IOException e) {
            System.out.println("Err name already exists (even if is used for a file)");
        }


    }

    public static void main(String[] args) {
        ResourcesOld.clean();
        Create c = new Create();

        c.createDirectories();
        c.createDirectories();
        Print.Delimitators.equal();

        c.createDirectory();
        c.createDirectory();
        Print.Delimitators.equal();

        c.createDirWhenNameAlreadyExists();
    }
}


