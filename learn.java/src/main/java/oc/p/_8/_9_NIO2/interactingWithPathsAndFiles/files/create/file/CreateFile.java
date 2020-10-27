package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.create.file;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path	createFile(Path path, FileAttribute<?>... attrs)
 * Creates a new empty file, failing if the file already exists.
 *
 * static Path	createLink(Path link, Path existing)
 * Creates a new link (directory entry) for an existing file (optional operation).
 *
 * static Path	createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs)
 * Creates a symbolic link to a target (optional operation).
 */
class CreateFile {

    Path base = ResourcesOld.Create.SrcMainResources.createDirectories(this.getClass().getPackage());

    void m() {
        Path p = Paths.get(base.toString());
        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("Err on exiting name (even if it's a directory)");
        }
    }

    void m2(){
        Path p = Paths.get(base.toString(), "f");

        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("Err on duplicate");
        }
    }

    public static void main(String[] args) {
        ResourcesOld.clean();
        CreateFile cf = new CreateFile();

        cf.m();
        Print.Delimitators.newLine();

        cf.m2();
        cf.m2();
    }
}
