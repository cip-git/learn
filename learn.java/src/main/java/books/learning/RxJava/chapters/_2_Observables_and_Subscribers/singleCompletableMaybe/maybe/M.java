package books.learning.RxJava.chapters._2_Observables_and_Subscribers.singleCompletableMaybe.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Maybe is just like a Single except that it allows no emission to occur at all
 *
 * A given Maybe<T> will only emit 0 or 1 emissions.
 * It will pass the possible emission to onSuccess(), and in either case,
 * it will call onComplete() when done.
 * Maybe.just() can be used to create a Maybe emitting the single item.
 * Maybe.empty() will create a Maybe that yields no emission.
 */
class M {

    static MaybeObserver<String> maybe = new MaybeObserver<String>() {
        @Override
        public void onSubscribe(Disposable disposable) {
            System.out.println("onSubscribe :" + disposable);
        }

        /**
         * Called only when an elem exists
         */
        @Override
        public void onSuccess(String s) {
            System.out.println("onSuccess: " + s);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        /**
         * Called only if no element is emitted
         */
        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    };

    static void m(){
        Maybe<String> source = Maybe.just("100");
        source.subscribe(maybe);

        System.out.println();

        Maybe<String> noSource = Maybe.empty();
        noSource.subscribe(maybe);
    }

    static void m2(){
        Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");

        source.firstElement()
                .subscribe(maybe);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
