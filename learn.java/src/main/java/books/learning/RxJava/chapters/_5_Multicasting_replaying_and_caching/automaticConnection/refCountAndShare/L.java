package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.automaticConnection.refCountAndShare;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.concurrent.TimeUnit;

/**
 * .publish().refCount() == share()
 */

class L {

    static void m() throws InterruptedException {
        final Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS)
//                .publish()
//                .refCount();
        .share();

        longObservable
                .take(5)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(3);

        longObservable
                .take(2)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(3);

        longObservable
                .take(2)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
