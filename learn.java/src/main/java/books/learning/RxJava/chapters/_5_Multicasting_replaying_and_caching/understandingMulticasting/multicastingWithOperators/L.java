package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.understandingMulticasting.multicastingWithOperators;

import books.learning.RxJava.chapters.Util;
import books.learning.RxJava.chapters.util.PrintObserver;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

class L {

    static final Observable<Integer> source = Observable.range(1, 3);

    static void m(){
        final Observable<Integer> observable = source.map(Util::randomInt);

        observable.subscribe(Util.printObserver());
        observable.subscribe(Util.printObserver());
    }

    static void m2(){
        final ConnectableObservable<Integer> publish =
                source
                .map(Util::randomInt)
                .publish();

        source.subscribe(Util.printObserver());
        source.subscribe(Util.printObserver());

        publish.connect();
    }

    static void m3(){
        final ConnectableObservable<Integer> publish = source.publish();
        final Observable<Integer> observable = publish.map(Util::randomInt);

        observable.subscribe(Util.printObserver());
        observable.subscribe();

        publish.connect();
    }


    public static void main(String[] args) {
//        m();
//        m2();
        m3();

    }
}
