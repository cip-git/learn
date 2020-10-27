package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.introducingRxJavaConcurrecny;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * By default, Observables execute work on the immediate thread,
 * which is the thread that declared the Observer and subscribed it
 * which was the main thread that kicked off our main() method.
 *
 * But as hinted in a few other examples, not all Observables will fire on the immediate thread:
 * Observable.interval()
 */
class L {

    static void m() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + " Mississipi")
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
