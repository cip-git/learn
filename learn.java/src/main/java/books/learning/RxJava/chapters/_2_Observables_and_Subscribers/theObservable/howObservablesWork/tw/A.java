package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObservable.howObservablesWork.tw;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class A {

    static Observer observer = new Observer () {
        @Override
        public void onSubscribe(Disposable disposable) {
            System.out.println("onSubscribe");
        }

        @Override
        public void onNext(Object s) {
            System.out.println(s);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("onError: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    };

    static void m() {
        ObservableSources.GREEK_ALPHABET
//        ObservableSources.RANDOM_NUMBERS_WITH_AE
                .doOnSubscribe(d -> System.out.println("doOnSubscribe"))
                .doOnNext(s -> System.out.println("doOnNext: " + s))
                .doAfterNext(s -> System.out.println("doAfterNext: " + s))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnError(t -> System.out.println("doOnError"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate"))
                .subscribe(observer);
    }

    public static void main(String[] args) {
        m();
    }
}
