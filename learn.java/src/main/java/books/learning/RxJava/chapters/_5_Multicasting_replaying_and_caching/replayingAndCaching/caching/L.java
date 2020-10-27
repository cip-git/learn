package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.replayingAndCaching.caching;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

/**
 * cache(): used when you want to cache all emissions indefinitely for the long term and do not need
 * to control the subscription behavior to the source with ConnectableObservable
 */
class L {

    static void m() {
        final Observable<Integer> observable = Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .scan(0, (total, nxt) -> total + nxt)
                .cache();

        observable.subscribe(Util.printObserver());
        observable.subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
        m();
    }
}
