package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions.tw.autoCloseble;

import java.util.stream.Stream;

class C {

    static class D implements AutoCloseable{

        public D() {
            throw new RuntimeException("D open exception");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("D");
        }
    }

    static class W implements AutoCloseable{
        @Override
        public void close() throws Exception {
            throw new Exception("W");
        }
    }

    static void m(){
        try(
                D d = new D();
                W w = new W();
        ) {
            throw new RuntimeException("method body exception");
        } catch (Exception e) {
            System.out.println("The first exception");
            System.out.println(e.getMessage());
            System.out.println("The suppressed exceptions");
            Stream
                    .of(e.getSuppressed())
                    .map(Throwable::getMessage)
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        m();
    }
}
