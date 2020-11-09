package oc.p._11._5_ExceptionsAssertionsAndLocalization.automatingResourceManagement.newEffectiveFinalFeature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class R {


    void relax() throws IOException {
        final var bookReader = new FileReader("4");
        final FileReader movieReader = new FileReader("5");

        try (
                bookReader;
                final FileReader reader = new FileReader("6");
                movieReader){
            System.out.println("try block");
        }finally {
            System.out.println("finaly block");
        }
    }

    public static void main(String[] args) throws IOException {
        var r = new R();

        r.relax();;
    }
}
