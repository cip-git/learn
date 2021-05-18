package oc.p._11._8_IO.Working_With_IO_Stream_Classes.review_of_stream_classes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class R {

    static void m() throws IOException {

        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                OutputStreamWriter osr = new OutputStreamWriter(System.out)
        ) {
        }
    }
}
