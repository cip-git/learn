package oc.p._8._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileModifications;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.*;

/**
 * public static FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException
 *
 * public static Path setLastModifiedTime(Path path, FileTime time) throws IOException
 */
class Modifications {

    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "m.file");

    public static void main(String[] args) throws IOException {
        Modifications m = new Modifications();

        m.m();
        m.m2();
    }

    void m() throws IOException {
        FileTime ft = Files.getLastModifiedTime(path);
        System.out.println(ft);

        System.out.println(ft.toInstant());
    }

    void m2() throws IOException {
        FileTime ft = FileTime.from(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(3000, 10, 10), LocalTime.now()),
                ZoneId.systemDefault()).toInstant());

        path = Files.setLastModifiedTime(path, ft);  //Modification time can be set in future or in the past

        ft  = Files.getLastModifiedTime(path);
        System.out.println(ft);
    }
}
