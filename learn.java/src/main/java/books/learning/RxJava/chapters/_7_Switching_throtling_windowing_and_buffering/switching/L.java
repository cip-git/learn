package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.switching;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * There is a powerful operator called switchMap().
 * Its usage feels like flatMap(), but it has one important behavioral difference:
 * it will emit from the latest Observable derived from the latest emission
 * and dispose of any previous Observables that were processing.
 * In other words, it allows you to cancel an emitting Observable and switch to a new one,
 * preventing stale or redundant processing.
 */
class L {

    public static final Observable<String> ITEMS = Observable
            .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon",
                    "Zeta", "Eta", "Theta", "Iota");

    static void m() throws InterruptedException {
        ITEMS
                .concatMap( s -> Observable.just(s).delay(Util.randomInt(2000), TimeUnit.MILLISECONDS))
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(20);
    }

    static void m2() throws InterruptedException {
        final Observable<String> processedItems = ITEMS
                .concatMap(s -> Observable.just(s).delay(Util.randomInt(2000), TimeUnit.MILLISECONDS));

        Observable
                .interval(3, TimeUnit.SECONDS)
                .switchMap(i -> processedItems.doOnDispose(() -> System.out.println("Disposing! Staring next")))
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(20);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
