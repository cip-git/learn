package oc.p._8._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

/**
 * Stream<T>	skip(long n)
 *              Returns a stream consisting of the remaining elements of this stream after discarding the first
 *              n elements of the stream.
 */
class Skip {
    static void m(){
        Util.infinite().skip(3).limit(3).forEach(System.out::println);
    }

    static void m2(){
        Util.finite().skip(2).forEach(System.out::println);
    }

    static void m3(){
        Util.empty().skip(3).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        createAndPopulate();
//        m2();
        m3();
    }

}
