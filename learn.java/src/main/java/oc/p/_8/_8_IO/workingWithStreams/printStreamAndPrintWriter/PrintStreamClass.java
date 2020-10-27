package oc.p._8._8_IO.workingWithStreams.printStreamAndPrintWriter;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * PrintStream	printf(String format, Object... args)
 *
 * PrintStream	printf(Locale l, String format, Object... args)
 *
 * PrintStream	format(String format, Object... args)
 *
 * PrintStream	format(Locale l, String format, Object... args)
 */
class PrintStreamClass {
    File file;
    PrintStream printStream;

    {
        file = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "a.txt").toFile();
    }

    {
        printStream = System.out;
        printStream = System.err;
    }

    {
        try(PrintStream ps = new PrintStream(file.getPath());
            PrintStream ps2 = new PrintStream(file);
            PrintStream ps3 = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)))) {

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintStreamClass pw = new PrintStreamClass();

        pw.write();
        pw.printf();
        pw.format();

        ResourcesOld.clean();
    }

    void write() throws FileNotFoundException {
        try(PrintStream ps = new PrintStream(file)) {
            byte b = 0b01;
            while(b < (byte) 127) {
                ps.write(b);
                b++;
            }
        }
    }

    void print() {
        printStream = System.out;
        printStream.print(LocalDateTime.now());
    }

    void println() {
        printStream = System.out;
        printStream.println(LocalDateTime.now());
    }

    void printf() {
        printStream  = System.out;

        printStream.printf("Ana's time:  %s", LocalDateTime.now());

        System.out.println();

        Locale locale;
        locale = Locale.getDefault();
//        locale = Locale.US;
        printStream.printf(locale, "I have %f", 2125.7d);
        System.out.println();
    }

    void format(){
        printStream = System.out;
        printStream.format("Ana's time : %s", LocalDateTime.now());

        System.out.println();
        Locale locale;
        locale = Locale.getDefault();
        printStream.format(locale, "I have %f", 2125.7d);
    }
}
