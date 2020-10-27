package oc.p._8._9_NIO2.introducingNIO2.creatingPaths.usingThePathsClass;

import utils.resources.files.ResourcesOld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Uri {

    Path file = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "a");

    public static void main(String[] args) throws IOException, URISyntaxException {
        Uri u = new Uri();
        u.create();
        u.read();
    }

    void create() {
        try (BufferedWriter bw = Files.newBufferedWriter(file)) {
            bw.write("Line 1");
            bw.newLine();
            bw.write("Line 2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read() throws URISyntaxException, IOException {
        String l = "file:///" + file.toAbsolutePath().toString().replace(File.separatorChar, '/');
        System.out.println(l);

        Path p = Paths.get(new URI(l));
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
