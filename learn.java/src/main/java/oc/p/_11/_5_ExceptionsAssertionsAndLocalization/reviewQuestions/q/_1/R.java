package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._1;

class R {

    public static void main(String[] args) {
//        new R().new Danger(23);

//        String s = (String) null;
        String s = null;
        System.out.println(s);
        System.out.println((String) null);
    }

    class Danger extends RuntimeException {

        Danger(String msg) {
            super();
        }

        Danger(int val) {
            super((String) null);
            System.out.println((String) null);
        }
    }

    class Catastrophe extends Exception {
        Catastrophe(Throwable c) throws RuntimeException {
            super(new Exception());
            c.printStackTrace();
        }
    }

    class Emergency extends Danger {

        public Emergency(String msg) {
            super(msg);
        }

        public Emergency(int val) {
            super(val);
        }
    }
}
