package oc.p._11._8_IO.Interacting_With_Users.reading_input_as_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class R {

    static void m() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter text: ");
        final String line = reader.readLine();

        System.out.println(line);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
