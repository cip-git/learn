package oc.p._8._6_ExceptionsAndAssertions.usingTryWithResources;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TWR {

    static Path read;
    static Path write;

    static {
        Package pkg = new TWR().getClass().getPackage();
//        read = Populate.NIO.File.Path.file(pkg, "read");
        read = null;
//        write = PathUtil.file(pkg, "write");
        write = null;
    }

    static void oldApproach() throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(read);
            out = Files.newBufferedWriter(write);
            String s = null;
            while ((s = in.readLine()) != null) {
                out.write(s);
                out.newLine();
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

    static void newApproach() throws IOException {
        try (BufferedReader in = Files.newBufferedReader(read);
             BufferedWriter out = Files.newBufferedWriter(write)) {
            String s;
            while ((s = in.readLine()) != null) {
                out.write(s);
                out.newLine();
            }
        }
    }

    static void peek() {
        try {
            Files.lines(write).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Print.Delimitators.newLine();
    }

    public static void main(String[] args) throws IOException {
        oldApproach();
        peek();
        newApproach();
        peek();
        ResourcesOld.clean();
    }
}
