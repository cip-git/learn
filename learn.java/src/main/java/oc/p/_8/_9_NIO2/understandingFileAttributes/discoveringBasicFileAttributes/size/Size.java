package oc.p._8._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.size;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * static long	size(Path path)
 * Returns the size of a file (in bytes).
 *
 * The Files.size() method on dir is undefined and system dependent
 *
 * The size returned by this method represents the conceptual size of the data,
 * and this may differ from the actual size on the persistence storage device
 * due to file system compression and organization.
 *
 * The size() method throws the checked IOException if the file does not exist
 * or if the process is unable to read the file information.
 */
class Size {

    Path p = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "size");

    void m() throws IOException {
        long l = Files.size(p);
        System.out.println(l);
    }

    public static void main(String[] args) throws IOException {
        Size size = new Size();
        size.m();
    }
}
