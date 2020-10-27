package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObserverInterface.shorthandWithLambdas;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

class Launcher {

    static Consumer<String> onNext = i-> System.out.println("onNext: " + i);
    static Consumer<Throwable> onError = t -> t.printStackTrace();
    static Action onComplete = () -> System.out.println("onComplete");

    static void m(){
        Observable<String> source = Observable.just("A", "B", "C", "D");

        source.subscribe(onNext, onError, onComplete);
    }

    public static void main(String[] args) {
        m();
    }
}
