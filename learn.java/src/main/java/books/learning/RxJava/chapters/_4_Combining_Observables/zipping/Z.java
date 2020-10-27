package books.learning.RxJava.chapters._4_Combining_Observables.zipping;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Zipping allows you to take an emission from each Observable
 * source and combine it into a single emission.
 * Each Observable can emit a different type,
 * but you can combine these different emitted types
 * into a single emission.
 */
class Z {

    static void m() {
        final Observable<Integer> range = Observable.range(1, 6);

        Observable.zip(ObservableSources.GREEK_ALPHABET, range, (s, i) -> s + " - " + i)
                .subscribe(System.out::println);
    }

    static void m2() throws InterruptedException {
        final Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(ObservableSources.GREEK_ALPHABET, source2, (s, i) -> s + " - " + i)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
