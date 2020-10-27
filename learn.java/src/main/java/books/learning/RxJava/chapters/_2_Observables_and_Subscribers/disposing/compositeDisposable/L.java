package books.learning.RxJava.chapters._2_Observables_and_Subscribers.disposing.compositeDisposable;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

class L {
    private static final CompositeDisposable disposables = new CompositeDisposable();

    static void m() throws InterruptedException {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d = seconds.subscribe(s -> System.out.println("Observer 1: " + s));
        Disposable d2 = seconds.subscribe(s -> System.out.println("Observer 2: " + s));

        TimeUnit.SECONDS.sleep(5);

        disposables.addAll(d, d2);
        disposables.dispose();

        TimeUnit.SECONDS.sleep(5);

        System.out.println(d.isDisposed());  //true
        System.out.println(d2.isDisposed());  //true
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
