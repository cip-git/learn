package books.learning.RxJava.chapters._4_Combining_Observables.concatenation.concatAndConcatWith;


import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * The Observable.concat() factory is the concatenation equivalent to Observable.merge().
 * It will combine the emissions of multiple Observables,
 * but will fire each one sequentially and only move to the next after onComplete()
 * is called.
 */
class C {

    static void m() {
        Observable.concat(ObservableSources.GREEK_ALPHABET, ObservableSources.ALPHABET)
                .subscribe(System.out::println);
    }

    static void m2() {
        ObservableSources.ALPHABET.concatWith(ObservableSources.GREEK_ALPHABET)
                .subscribe(System.out::println);
    }

    static void m3() throws InterruptedException {
        final Observable<String> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(2)
                .map(i -> i + 1)
                .map(i -> " source: " + i + " seconds");

        final Observable<String> source2 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 500) // emit elapsed milliseconds
                .map(l -> "source2: " + l + " milliseconds");


        Observable.concat(source, source2)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
        m3();
    }
}
