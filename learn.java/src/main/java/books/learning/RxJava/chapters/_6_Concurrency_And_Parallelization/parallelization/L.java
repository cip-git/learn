package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.parallelization;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

class L {

    static void need() {
        final long start = System.currentTimeMillis();

        Observable.range(1, 10)
                .map(Util::intenseCalculation)
                .blockingSubscribe(Util.printObserver());

        final long end = System.currentTimeMillis();

        System.out.println("Took: " + (end - start));
    }

    static void sol() {
        final long start = System.currentTimeMillis();

        Observable.range(1, 10)
                .flatMap(
                        i ->
                        Observable
                                .just(i)
                                .subscribeOn(Schedulers.computation())
                                .map(Util::intenseCalculation))
                .blockingSubscribe(Util.printObserver());

        final long end = System.currentTimeMillis();

        System.out.println("Took: " + (end - start));
    }

    static void sol2() {
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        AtomicInteger ai = new AtomicInteger(0);

        final long start = System.currentTimeMillis();
        Observable
                .range(1, 10)
                .groupBy(i -> ai.incrementAndGet() % availableProcessors)
                .flatMap(
                        grp -> grp
                                .observeOn(Schedulers.io())
                                .map(Util::intenseCalculation))
                .blockingSubscribe(Util.printObserver());
        final long end = System.currentTimeMillis();
        System.out.println("Took: " + (end - start));
    }


    public static void main(String[] args) {
//        need();
//        sol();
        sol2();
    }
}