package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.never;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * A close cousin of Observable.empty() is Observable.never().
 * The only difference between them is that it never calls onComplete(),
 * forever leaving observers waiting for emissions but never actually giving any.
 */
class L {

    static void m() throws InterruptedException {
        Observable<String> source = Observable.never();

        source.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe: " + disposable);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
