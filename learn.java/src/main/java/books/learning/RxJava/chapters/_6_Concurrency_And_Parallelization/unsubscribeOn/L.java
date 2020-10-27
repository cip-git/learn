package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.unsubscribeOn;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * When you dispose an Observable, sometimes, that can be an expensive operation depending
 * on the nature of the source.
 * For instance, if your Observable is emitting the results of a database query
 * using RxJava-JDBC, it can be expensive to stop and dispose that Observable because
 * it needs to shut down the JDBC resources it is using.
 */
class L {

    public static final Action ACTION = () -> System.out.println("Disposing on thread: " + Thread.currentThread().getName());

    static void need() throws InterruptedException {

        final Disposable disposable = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(ACTION)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
        disposable.dispose();
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     *  The Disposal is being done by the IO Scheduler,
     *  whose thread is identified by the name RxCachedThreadScheduler-1.
     *  This allows the main thread to kick off disposal and continue without waiting for
     *  it to complete.
     */
    static void sol() throws InterruptedException {
        final Disposable disposable = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(ACTION)
                .unsubscribeOn(Schedulers.io())
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
        disposable.dispose();
//        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        need();
        sol();
    }
}
