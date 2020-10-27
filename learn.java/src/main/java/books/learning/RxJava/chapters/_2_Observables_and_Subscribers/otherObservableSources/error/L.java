package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.error;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class L {

    static void m(){
        Observable<Exception> source = Observable.error(new Exception("Crush and burn"));

        source.subscribe(new Observer<Exception>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Exception e) {
                System.out.println("onNext: " + e);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }

    public static void main(String[] args) {
        m();
    }
}
