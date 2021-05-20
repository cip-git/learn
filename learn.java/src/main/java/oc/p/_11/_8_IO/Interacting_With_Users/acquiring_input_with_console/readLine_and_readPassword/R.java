package oc.p._11._8_IO.Interacting_With_Users.acquiring_input_with_console.readLine_and_readPassword;

import java.io.Console;

class R {

    Console console = System.console();


    {
        final String line = console.readLine();
        console.readLine("Format: [%s]", "user");

        final char[] chars = console.readPassword();
        final char[] chars2 = console.readPassword("Input pass: [%s]", "user");
    }

}
