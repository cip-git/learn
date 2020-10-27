package books.learning.RxJava.chapters._4_Combining_Observables.concatenation.concatMap;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;

/**
 * Just as there is flatMap(), which dynamically merges Observables derived off each emission,
 * there is a concatenation counterpart called concatMap().
 * You should prefer this operator if you care about ordering and want each Observable mapped
 * from each emission to finish before starting the next one.
 * More specifically, concatMap() will merge each mapped Observable sequentially and fire
 * it one at a time. It will only move to the next Observable when the current one
 * calls onComplete().
 * If source emissions produce Observables faster than concatMap() can emit from them,
 * those Observables will be queued.
 */
class CM {

    static void m() {
        ObservableSources.GREEK_ALPHABET
                .concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
