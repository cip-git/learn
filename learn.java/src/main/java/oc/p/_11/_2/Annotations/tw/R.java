package oc.p._11._2.Annotations.tw;

import java.util.List;

class R {

    @SuppressWarnings("unchecked")
    private static void m(List<String>... la){
        System.out.println(la.length);
    }

    @SuppressWarnings("unchecked")
    private static void m2(){
        m(List.of("a"));
    }

    @SafeVarargs
    private static void mm(List<String>... la){
        System.out.println(la.length);
    }

    private static void mm2(){
        mm(List.of("a"));
    }

    public static void main(String[] args) {
        m2();
        mm2();
    }
}
