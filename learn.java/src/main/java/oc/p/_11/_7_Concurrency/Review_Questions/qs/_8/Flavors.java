package oc.p._11._7_Concurrency.Review_Questions.qs._8;

import java.util.stream.LongStream;

class Flavors {
    private static int counter;

    static void countIceCreamFlavors(){
        counter = 0;
        Runnable task = () -> counter++;

        LongStream
                .range(1, 500)
                .forEach(i -> new Thread(task).run());
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countIceCreamFlavors();
    }
}
