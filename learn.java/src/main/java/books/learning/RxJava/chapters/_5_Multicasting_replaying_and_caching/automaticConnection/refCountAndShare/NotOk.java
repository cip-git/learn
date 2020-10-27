package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.automaticConnection.refCountAndShare;

import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class NotOk {

    static void m(){
        final Observable<String> observable = ObservableSources.GREEK_ALPHABET
                .replay(1)
                .refCount();

        observable.subscribe(Util.printObserver());
        observable.subscribe(Util.printObserver());
    }

    static void m2() throws InterruptedException {
        final Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .refCount();

        observable.take(3)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(2);

        observable.take(3)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(4);
    }


    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
    }

}
