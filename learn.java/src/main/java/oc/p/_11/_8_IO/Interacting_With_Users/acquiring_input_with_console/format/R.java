package oc.p._11._8_IO.Interacting_With_Users.acquiring_input_with_console.format;

import java.io.Console;

class R {

    Console console = System.console();

    {
        console = console.format("Format: [%d]", 2);

        console = console.printf("Format: [%d]", 2);
    }
}
