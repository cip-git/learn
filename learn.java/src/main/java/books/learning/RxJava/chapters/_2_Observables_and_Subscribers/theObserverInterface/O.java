package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObserverInterface;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class O<T> {

    void m() {


        Observer<T> observer = new Observer<T>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(T t) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

    }


    void m2() {
        Disposable d = new Disposable() {
            @Override
            public void dispose() {

            }

            @Override
            public boolean isDisposed() {
                return false;
            }
        };
    }
}
