package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.introducingRxJavaConcurrecny.keepingAndApplicationAlive;


import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

class L {

    static void m() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(Util::intenseCalculation)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }

    /**
     * Blocks the main thread, till Observable call toComplete()
     */
    static void m2(){
        ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation)
                .blockingSubscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done"));
    }


    public static void main(String[] args) {
        m2();
    }


}
