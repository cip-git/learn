package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.empty;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class L {

    static void m(){
        Observable<String> empty = Observable.empty();

        empty.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe: " + disposable.toString());
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
    }

    public static void main(String[] args) {
        m();
    }
}
