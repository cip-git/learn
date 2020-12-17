package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._12;

class R {

    void m() {
        try (final E e = new E()) {
            System.out.println("Body");
        }
    }

    class E implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Closing A");
        }
    }
}
