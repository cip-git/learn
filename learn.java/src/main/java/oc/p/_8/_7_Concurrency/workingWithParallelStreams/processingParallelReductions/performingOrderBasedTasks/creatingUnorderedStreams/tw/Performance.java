package oc.p._8._7_Concurrency.workingWithParallelStreams.processingParallelReductions.performingOrderBasedTasks.creatingUnorderedStreams.tw;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Performance {

    public static void main(String[] args) {
        Performance p = new Performance();
        p.callM();
    }

    Stream <Integer> stream(int max) {
        return IntStream.rangeClosed(1, max)
                .parallel()
                .mapToObj(i -> i);
    }

    void m(Stream <Integer> stream, int max) {
        long s = System.currentTimeMillis();
        final long count = stream.skip(max / 2)
                .limit(max / 3)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 13 == 0)
                .count();
        long e = System.currentTimeMillis();
        System.out.println("Duration: " + (e - s));
        System.out.println("Count: " + count);
    }

    void callM() {
        m(stream(Integer.MAX_VALUE), Integer.MAX_VALUE);
        m(stream(Integer.MAX_VALUE).unordered(), Integer.MAX_VALUE);
    }
}
