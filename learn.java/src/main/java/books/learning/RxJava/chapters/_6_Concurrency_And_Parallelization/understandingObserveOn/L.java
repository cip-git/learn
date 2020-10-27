package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understandingObserveOn;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * The subscribeOn() operator instructs the source Observable which Scheduler to emit emissions on.
 * If subscribeOn() is the only concurrent operation in an Observable chain,
 * the thread from that Scheduler will work the entire Observable chain,
 * pushing emissions from the source all the way to the final Observer.
 *
 * The observeOn() operator, however, will intercept emissions at that point in the Observable
 * chain and switch them to a different Scheduler going forward.
 *
 * Unlike subscribeOn(), the placement of observeOn() matters.
 * It will leave all operations upstream on the default or subscribeOn()-defined Scheduler,
 * but will switch to a different Scheduler downstream.
 *
 * Here, I can have an Observable emit a series of strings that are /-separated values and
 * break them up on an IO Scheduler. But after that, I can switch to a computation Scheduler
 * to filter only numbers and calculate their sum, as shown in the following code snippet.
 */
class L {

    static void m() throws InterruptedException {
        Observable
                .just(
                        "WHISKEY/27653/TANGO",
                        "6555/BRAVO",
                        "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s->Observable.fromArray(s.split("/")))
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total + next)
                .subscribe(Util.printMaybeObserver());

        TimeUnit.SECONDS.sleep(5);
    }

    static void m2() throws InterruptedException {
        Observable
                .just(
                        "WHISKEY/27653/TANGO",
                        "6555/BRAVO",
                        "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .doOnNext(s -> System.out.println("Split on thread: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .filter( s -> s.matches("[0-9]+"))
                .reduce((total, next) -> total + next)
                .doOnSuccess(s -> System.out.println("Calculated sum: " + s + " on thread: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.io())
                .map(i -> i.toString())
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
