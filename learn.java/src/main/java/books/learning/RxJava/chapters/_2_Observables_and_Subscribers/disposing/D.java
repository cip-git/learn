package books.learning.RxJava.chapters._2_Observables_and_Subscribers.disposing;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * When you subscribe() to an Observable to receive emissions,
 * a stream is created to process these emissions through the Observable chain.
 * Of course, this uses resources. When we are done, we want to dispose of these resources
 * so that they can be garbage-collected.
 * The finite Observables that call onComplete() will typically
 * dispose of themselves safely when they are done.
 * But if you are working with infinite or long-running Observables,
 * you likely will run into situations where you want to explicitly stop
 * the emissions and dispose of everything associated with that subscription.
 * As a matter of fact, you cannot trust the garbage collector to take care
 * of active subscriptions that you no longer need, and
 * explicit disposal is necessary in order to prevent memory leaks.
 *
 * The Disposable is a link between an Observable and an active Observer,
 * and you can call its dispose() method to stop emissions and dispose of all
 * resources used for that Observer.
 * It also has an isDisposed() method, indicating whether it has been disposed of already.
 */
import java.util.concurrent.TimeUnit;

class D {

    static Disposable disposable = new Disposable() {
        @Override
        public void dispose() {
            System.out.println("Dispose");
        }

        @Override
        public boolean isDisposed() {
            return false;
        }
    };

    static void m() throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d = source.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done"));

        TimeUnit.SECONDS.sleep(5);

        //dispose and stop emissions
        d.dispose();
        System.out.println(d.isDisposed());

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}

