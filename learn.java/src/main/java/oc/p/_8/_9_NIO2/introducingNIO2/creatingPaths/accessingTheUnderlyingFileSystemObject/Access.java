package oc.p._8._9_NIO2.introducingNIO2.creatingPaths.accessingTheUnderlyingFileSystemObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Paths.get(): java.nio.directory.FileSystems.getPath()
 */
class Access {
    static Path p;
    static FileSystem fileSystem;

    static void m() throws URISyntaxException {

        fileSystem = FileSystems.getDefault();
        fileSystem = FileSystems.getFileSystem(new URI("www.google.com"));

        p = Paths.get("a");
        System.out.println(p);

        p = FileSystems.getDefault().getPath("a");  //equivalent with the above method
        System.out.println(p);

        p = FileSystems.getFileSystem(new URI("www.google.com")).getPath("a");
        System.out.println(p);
    }

    public static void main(String[] args) throws URISyntaxException {
        m();
    }
}
