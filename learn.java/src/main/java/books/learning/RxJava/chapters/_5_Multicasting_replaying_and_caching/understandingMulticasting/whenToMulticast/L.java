package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.understandingMulticasting.whenToMulticast;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import static books.learning.RxJava.chapters.Util.*;

/**
 * Multicasting is helpful in preventing redundant work being done by multiple Observers
 * and instead makes all Observers subscribe to a single stream, at least to the point where they
 * have operations in common
 */
class L {

    static void m(){
        final ConnectableObservable<Integer> connectableObservable = Observable.range(1, 3)
                .map(Util::randomInt)
                .publish();

        connectableObservable.subscribe(printObserver());

        connectableObservable
                .reduce(0 , (t, n) -> Integer.sum(t, n))
                .subscribe(printIntegerSingleObserver());

        connectableObservable.connect();
    }

    public static void main(String[] args) {
        m();
    }
}
