package oc.p._11._8_IO.Interacting_With_Users.acquiring_input_with_console.reader_and_writer;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;

class R {

    Console console = System.console();

    {
        final Reader reader = console.reader();
        final PrintWriter writer = console.writer();
    }

}
