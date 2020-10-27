package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.interval;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

class L {

    static void m() throws InterruptedException {
        Observable
                .interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " Mississippi"));
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * Interval retrieves a cold Observable
     */
    static void m2() throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        source.subscribe(l -> System.out.println("Observer 1: " + l));
        TimeUnit.SECONDS.sleep(5);

        source.subscribe(l -> System.out.println("Observer 2: " + l));
        TimeUnit.SECONDS.sleep(5);
    }

    static void m3() throws InterruptedException {
        ConnectableObservable<Long> connectableObservable =
                Observable.interval(1, TimeUnit.SECONDS).publish();

        connectableObservable.subscribe(l -> System.out.println("Observer 1: " + l));
        connectableObservable.connect(); //actual start of emitting
        TimeUnit.SECONDS.sleep(5);

        connectableObservable.subscribe(l -> System.out.println("Observer 2: " + l));
        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
//        m2();
//        m3();
    }
}
