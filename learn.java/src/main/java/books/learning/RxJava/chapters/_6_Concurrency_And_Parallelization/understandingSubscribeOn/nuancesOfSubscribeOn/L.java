package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understandingSubscribeOn.nuancesOfSubscribeOn;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * It is important to note that subscribeOn() will have no practical effect with certain sources
 *
 * If you have multiple subscribeOn() calls on a given Observable chain,
 * the top-most one, or the one closest to the source,
 * will win and cause any subsequent ones to have no practical effect
 */
class L {

    static void m() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS, Schedulers.newThread())
                .subscribe(i -> System.out.println("Received: " + i + " on thread: " + Thread.currentThread().getName() ));

        TimeUnit.SECONDS.sleep(3);
    }


    static void m2() throws InterruptedException {
        ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .filter(s-> s.length() > 0)
                .subscribeOn(Schedulers.io())
                .subscribe(i -> System.out.println("Received " + i + "  " + Thread.currentThread().getName()));

        TimeUnit.SECONDS.sleep(2);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
