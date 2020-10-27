package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.copy;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path copy(Path source, Path target, CopyOption... options) throws IOException
 *
 * static long copy(InputStream source, OutputStream sink) throws IOException
 *
 * static long copy(InputStream in, Path target, CopyOption... options) throws IOException
 *
 * static long copy(Path source, OutputStream out) throws IOException
 */
class Copy {
    String loc = ResourcesOld.LocationOf.SrcMainResources.dir(this.getClass().getPackage());

    Path fromDir = Paths.get(loc, "fromDir");
    Path toDir = Paths.get(loc, "toDir");

    Path fromFile = Paths.get(fromDir.toString(), "from.file");
    Path toFile = Paths.get(toDir.toString(), "to.file");

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();

        Copy c = new Copy();
        c.init();

        c.copy();
    }

    void init() throws IOException {
        fromDir = Files.createDirectories(fromDir);
        toDir = Files.createDirectories(toDir);
        fromFile = Files.createFile(fromFile);
        fromFile = ResourcesOld.Populate.file(fromFile);
    }

    void copy() throws IOException {
        Files.copy(fromFile, toFile);
    }
}
