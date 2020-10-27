package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObserverInterface.implementingAndSubscribingToAnObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class Laucher {

    static void m(){
        Observable<String> source = Observable.just("A", "B", "C", "D", "E");

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        source.map(String::length)
                .filter(i->i>0)
                .subscribe(observer);
    }

    public static void main(String[] args) {
        m();
    }

}
