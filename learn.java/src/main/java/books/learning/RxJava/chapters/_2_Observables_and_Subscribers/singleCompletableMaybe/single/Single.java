package books.learning.RxJava.chapters._2_Observables_and_Subscribers.singleCompletableMaybe.single;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class Single {

    static void m(){
        SingleObserver<String> singleObserver = new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe: " + disposable.isDisposed());
            }

            @Override
            public void onSuccess(String s) {
                System.out.println("onSuccess essentially consolidates onNext and onComplete: " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        };

        io.reactivex.Single.just("Hello")
                .subscribe(singleObserver);
    }

    static void m2(){
        Observable<String> source = Observable.just("Alpha","Beta","Gamma");

        io.reactivex.Single<String> first = source.first("None");

        first.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
//        m2();
    }
}
