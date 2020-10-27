package oc.p._8._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations;

/**
 * Stream<T>	peek(Consumer<? super T> action)
 * Returns a stream consisting of the elements of this stream,
 * additionally performing the provided action on each element as elements
 * are consumed from the resulting stream.
 */
class Peek {

    static void m() {
        Util.infinite().peek(System.out::println).limit(5).reduce(Integer::max).ifPresent(System.out::println);
    }

    static void m2(){
        Util.infinite().peek(System.out::println).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
    }
}
