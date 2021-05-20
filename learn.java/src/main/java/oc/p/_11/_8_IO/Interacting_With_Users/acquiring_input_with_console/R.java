package oc.p._11._8_IO.Interacting_With_Users.acquiring_input_with_console;

import java.io.Console;
import java.io.PrintWriter;

import oc.p._11._2.Annotations.Rule;

@Rule("The Console class is a singleton." +
        "It is accessible only from a factory method and " +
        "only one instance of it is created by the JVM")
class R {

    public static void main(String[] args) {
        m();
    }

    static void m() {
        Console console = System.console();

        if (console != null) {
            final String line = console.readLine();
            console.writer().println(line);
        } else {
            System.err.println("Console not available");
        }
    }

    static void m2(){
        PrintWriter pw = new PrintWriter(System.out);
    }
}
