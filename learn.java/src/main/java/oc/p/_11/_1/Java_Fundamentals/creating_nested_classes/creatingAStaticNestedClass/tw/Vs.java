package oc.p._11._1.Java_Fundamentals.creating_nested_classes.creatingAStaticNestedClass.tw;

class Vs {

    static class SIC {
    }

    class IC {
    }
}

class Run {
    static void m() {
        Vs vs = new Vs();

        Vs.IC ic = new Vs().new IC();
        ic = vs.new IC();

        Vs.SIC sic = new Vs.SIC();
//        sic = vs.new SIC();  //compiler error
    }
}
