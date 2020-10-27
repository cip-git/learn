package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions.tw.autoCloseble;

class A {

    static class D implements AutoCloseable{
        @Override
        public void close() throws Exception {
            System.out.println("D");
        }
    }

    static class W implements AutoCloseable{
        @Override
        public void close() throws Exception {
            System.out.println("W");
        }
    }

    public static void main(String[] args) {
        try(
                D d = new D();
                W w = new W()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
