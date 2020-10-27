package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.automaticConnection.autoConnect;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

class L {

    public static final Observable<Integer> OBSERVABLE = Observable.range(1, 3)
            .map(Util::randomInt)
            .publish()
            .autoConnect(2);

    static void m(){
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
    }

    static void m2(){
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
        OBSERVABLE.subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
