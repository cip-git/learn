package oc.p._8._1_AdvancedClassDesign.review.q._20;

class F2 {

    String walk = this.getClass().getSimpleName();

    static class E2 extends F2{
        {
            super.walk = this.getClass().getSimpleName();
        }
    }

    public static void main(String[] args) {
        F2 f = new E2();
        E2 e = new E2();

        System.out.println(f.walk);  //E2
        System.out.println(e.walk);  //E2
    }
}
