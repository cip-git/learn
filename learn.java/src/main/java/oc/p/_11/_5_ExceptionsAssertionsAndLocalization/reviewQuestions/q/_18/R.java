package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._18;

import java.io.Closeable;
import java.io.IOException;

class R {

    public static void main(String[] args) {
        var d = new Door();
        try (d; var w = new Window()) {
            System.out.println("T");
        } catch (Exception e) {
            System.out.println("E");
        }finally {
            System.out.println("F");
        }
    }

    static class Door implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("D");
        }
    }

    static class Window implements Closeable {
        @Override
        public void close() {
            System.out.println("W");
        }
    }
}
