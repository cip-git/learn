package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understandingObserveOn;

import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

class L2 {

    static void m() throws InterruptedException {
        ObservableSources.GREEK_ALPHABET
                .subscribeOn(Schedulers.io())
                .filter(s -> s.startsWith("A"))
                .doOnNext(s -> System.out.println("doOnNext: " + s + " on thread: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .doOnNext(s -> System.out.println("doOnNext: " + s + " on thread: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(5);
    }


    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
