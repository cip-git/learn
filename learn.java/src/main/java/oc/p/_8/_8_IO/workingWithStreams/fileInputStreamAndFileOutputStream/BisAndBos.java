package oc.p._8._8_IO.workingWithStreams.fileInputStreamAndFileOutputStream;

import utils.resources.files.ResourcesOld;

import java.io.*;

/**
 * It is recommended that the buffer size is a power
 * of 2
 * <p>
 * Only BufferedInputStream and BufferedReader return true for markSupported
 */
class BisAndBos {

    File file, copy;

    {
        file = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "coldSource.jpg").toFile();
    }

    public static void main(String[] args) throws IOException {
        BisAndBos bb = new BisAndBos();

        bb.m();

        ResourcesOld.clean();
    }

    void m() throws IOException {
        copy = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "copy.jpg").toFile();
        try (InputStream in = new BufferedInputStream(new FileInputStream(file));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {
            byte[] buff = new byte[16];
            int lengthRead;
            /**
             * Reads some number of bytes from the
             * input stream and stores them into
             * the buffer array.
             * The number of bytes actually read is
             * returned as an integer
             */
            while ((lengthRead = in.read(buff)) > 0) {
                /**
                 *  Writes len bytes from the specified
                 *  byte array
                 *  starting at offset off to this output stream.
                 */
                out.write(buff, 0, lengthRead);
                /**
                 * Same as write(buff, 0, buff.length);
                 */
                out.write(buff);
                out.flush();
            }
        }
    }
}
