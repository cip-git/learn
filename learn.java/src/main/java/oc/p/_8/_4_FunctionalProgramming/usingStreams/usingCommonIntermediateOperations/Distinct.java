package oc.p._8._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

/**
 * Stream<T>	distinct()
 *
 * Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
 */
class Distinct {

    static void m(){
        Util.infinite().distinct().limit(3).forEach(System.out::println);
    }

    static void m2(){
        Util.finite().distinct().forEach(System.out::println);
    }

    static void m3(){
        Util.empty().distinct().forEach(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
        m3();
    }
}
