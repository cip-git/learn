package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.understandingMulticasting;

import io.reactivex.Observable;

/**
 * Using ConnectableObservable will force emissions from the source to become hot,
 * publishing a single stream of emissions to all Observers at the same time, rather then
 * giving a separate stream to each Observer.
 * This idea of stream consolidation is knows as multicasting.
 */
class L {


    static final Observable<Integer> observable = Observable.range(1, 3);

    static void m() {
        observable.subscribe(i-> System.out.println("obs: " + i), Throwable::printStackTrace, () -> System.out.println("obs onComplete()"));
        observable.subscribe(i-> System.out.println("obs2: " + i), Throwable::printStackTrace, () -> System.out.println("obs2 onComplete()"));
    }

    public static void main(String[] args) {
        m();
    }
}
