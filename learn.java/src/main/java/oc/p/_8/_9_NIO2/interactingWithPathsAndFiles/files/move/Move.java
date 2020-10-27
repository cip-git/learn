package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.move;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * static Path	move(Path source, Path target, CopyOption... options)
 * Move or rename a file to a target file.
 */
class Move {

    String loc = ResourcesOld.LocationOf.SrcMainResources.dir(this.getClass().getPackage());

    Path fromDir = Paths.get(loc, "fromDir");
    Path toDir = Paths.get(loc, "toDir");

    Path from = Paths.get(fromDir.toString(), "from.file");
    Path to = Paths.get(toDir.toString(), "to.file");

    void init() throws IOException {
        fromDir = Files.createDirectories(fromDir);
        toDir = Files.createDirectories(toDir);
        from = Files.createFile(from);
        from = ResourcesOld.Populate.file(from);
    }

    void move() throws IOException {
        from = Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();

        Move m = new Move();
        m.init();

        m.move();
    }
}

