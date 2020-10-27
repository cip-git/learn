package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.readAndWrite.newBuffered;

import utils.resources.files.ResourcesOld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Opens a file for reading, returning a BufferedReader to read text
 * from the file in an efficient manner.
 *
 * public static BufferedReader newBufferedReader(Path path) throws IOException
 * public static BufferedReader newBufferedReader(Path path, Charset cs) throws IOException
 *
 * Opens or creates a file for writing, returning a BufferedWriter to write text to the file in an efficient manner.
 *
 * public static BufferedWriter newBufferedWriter(Path path, OpenOption... options) throws IOException
 * public static BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options) throws IOException
 */
class RW {

    Path path = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "from");

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        RW rw = new RW();

        rw.write();
        rw.read();

    }

    void write() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("Thomas");
            bw.newLine();
            bw.write("is a cat");
        }
    }

    void read() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
