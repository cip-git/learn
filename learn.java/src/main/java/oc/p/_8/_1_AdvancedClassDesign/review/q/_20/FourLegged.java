package oc.p._8._1_AdvancedClassDesign.review.q._20;

class FourLegged {

    String walk = "walk";

    static class BabyRhino extends FourLegged{
        String walk = "toddle";
    }

    public static void main(String[] args) {
        FourLegged f = new BabyRhino();
        BabyRhino b = new BabyRhino();

        System.out.println(f.walk);
        System.out.println(b.walk);
    }
}
