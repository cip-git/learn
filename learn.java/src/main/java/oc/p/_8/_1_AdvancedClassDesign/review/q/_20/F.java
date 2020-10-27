package oc.p._8._1_AdvancedClassDesign.review.q._20;

class F {

    static String walk = new F().getClass().getSimpleName();

    static class E extends F{
        static String walk = new E().getClass().getSimpleName();
    }

    public static void main(String[] args) {
        F f = new E();
        E e = new E();

        System.out.println(f.walk);
        System.out.println(e.walk);
    }
}
