package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understandingSubscribeOn;

import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * The subscribeOn() operator will suggest to the source Observable upstream which
 * Scheduler to use and how to execute operations on one of its threads.
 * If that source is not already tied to a particular Scheduler,
 * it will use the Scheduler you specify.
 * It will then push emissions all the way to the final Observer using that thread
 * (unless you add observeOn() calls, which we will cover later).
 * You can put subscribeOn() anywhere in the Observable chain, and it will suggest to the
 * upstream all the way to the origin Observable which thread to execute emissions with.
 */
class L {
    /**
     * In the following example, it makes no difference whether you put this subscribeOn()
     * right after Observable.just() or after one of the operators
     */
    static void m() throws InterruptedException {
        ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())  //preferred way
                .map(String::length)
                .filter(i -> i>0)
                .subscribe(Util.printObserver());

        ObservableSources.ALPHABET
                .map(String::length)
                .subscribeOn(Schedulers.computation())
                .filter( i -> i > 0)
                .subscribe(Util.printObserver());

        ObservableSources.ALPHABET
                .map(String::length)
                .filter(i -> i> 0)
                .subscribeOn(Schedulers.computation())
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * Having multiple Observers to the same Observable with subscribeOn()
     * will result in each one getting its own thread
     */
    static void m2() throws InterruptedException {
        final Observable<Integer> source = ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation)
                .map(String::length);

        source.subscribe(Util.printObserver());
        source.subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * If we want only one thread to serve both Observers, we can multicast this operation.
     * Just make sure subscribeOn() is before the multicast operators:
     */
    static void m3() throws InterruptedException {
        final Observable<Integer> source = ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation)
                .map(String::length)
                .publish()
                .autoConnect(2);

        source.subscribe(Util.printObserver());
        source.subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(10);
    }


    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
//        m3();
    }
}
