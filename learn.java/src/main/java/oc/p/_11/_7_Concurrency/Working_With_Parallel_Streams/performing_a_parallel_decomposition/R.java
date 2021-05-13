package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.performing_a_parallel_decomposition;

import java.util.List;
import java.util.concurrent.TimeUnit;

class R {

    static int doWork(int input){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input;
    }

    static void m(){
        final long start = System.currentTimeMillis();
        List
                .of(1, 2, 3, 4, 5)
                .stream()
                .map(w -> doWork(w))
                .forEach(System.out::println);

        var timeTaken = (System.currentTimeMillis() -  start)/1000;
        System.out.println("seconds: " + timeTaken);
    }

    static void mParallel(){
        final long start = System.currentTimeMillis();
        List
                .of(1, 2, 3, 4, 5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(System.out::println);

        var timeTaken = (System.currentTimeMillis() -  start)/1000;
        System.out.println("seconds: " + timeTaken);
    }

    static void mParallelAndOrdered(){
        final long start = System.currentTimeMillis();
        List
                .of(1, 2, 3, 4, 5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEachOrdered(System.out::println);

        var timeTaken = (System.currentTimeMillis() -  start)/1000;
        System.out.println("seconds: " + timeTaken);
    }

    public static void main(String[] args) {
        m();
        System.out.println();
        mParallel();
        System.out.println();
        mParallelAndOrdered();
    }
}
