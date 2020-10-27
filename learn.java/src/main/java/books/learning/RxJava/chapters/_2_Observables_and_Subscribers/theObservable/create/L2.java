package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObservable.create;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class L2 {

    static void m(){
        ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
                emitter.onNext("D");
                emitter.onNext("E");
            }
        };
        Observable.create(observableOnSubscribe)
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    public static void main(String[] args) {
        m();
    }
}
