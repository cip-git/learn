package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.replayingAndCaching.replay;


import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * replay() holds onto previous emissions within a certain scope and
 * re-emit them when a new Observer comes in
 *
 *
 */
class R {

    static void m() throws InterruptedException {
        final Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();

        observable.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(3);

        observable.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * replay() should always be used with autoConnect(), never with refCount()
     */
    static void m2() throws InterruptedException {
        final Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .refCount();

        observable.take(2)
                .subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(3);

        observable.take(2)
                .subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(2);
    }

    static void m3() throws InterruptedException {
        final Observable<Long> observable = Observable.interval(500, TimeUnit.MILLISECONDS)
                .replay(1, TimeUnit.SECONDS)
                .autoConnect();

        observable.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(3);

        observable.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(1);
    }

    static void m4() throws InterruptedException {
        final Observable<Integer> observable = ObservableSources.GREEK_ALPHABET
                .replay(stringObservable -> stringObservable.map(String::length))
                .replay()
                .autoConnect();

        observable.take(2)
                .subscribe(Util.printObserver());

        observable.subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(1);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m3();
        m4();
    }
}
