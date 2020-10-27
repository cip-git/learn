package oc.p._11._4.functionalProgramming.usingStreams.terminalOperations.reduce;

import java.util.stream.Stream;

/**
 * The three-argument reduce() operation is useful when working with
 * parallel streams
 * because it allows the stream to be decomposed and reassembled by separate threads.
 * For example, if we needed to count the length of four 100-character strings,
 * the first two values and the last two values could be computed independently.
 * The intermediate result (200 + 200) would then be combined into the final value.
 *
 */
class R {

    static void m(){
        final String reduce = Stream
                .iterate(1, i -> i < 10, i -> i + 1)
                .reduce("a", (var s, var i) -> s + i, String::concat);
        System.out.println(reduce);
    }

    static void m2(){
        final String reduce = Stream
                .iterate(1, i -> i < 10, i -> i++)
                .reduce(
                        "",
                        (s, i) -> s.concat(Integer.toBinaryString(i)),
                        String::concat);
    }

    public static void main(String[] args) {
        m();
    }
}
