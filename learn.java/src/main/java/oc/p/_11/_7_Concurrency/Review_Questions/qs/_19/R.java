package oc.p._11._7_Concurrency.Review_Questions.qs._19;

import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

class R {

    public static void main(String[] args) {
        var s = Executors.newFixedThreadPool(10);

        DoubleStream
                .of(3.14159, 2.71828)
                .forEach(c ->  s.submit(() -> System.out.println(10 * c)));

        s.execute(() -> System.out.println("Printed"));
    }
}
