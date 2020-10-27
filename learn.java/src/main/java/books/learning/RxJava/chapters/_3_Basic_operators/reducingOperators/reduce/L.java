package books.learning.RxJava.chapters._3_Basic_operators.reducingOperators.reduce;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class L {

    static void m(){
        Maybe<Integer> maybe = ObservableSources.RANDOM_NUMBERS
                .reduce((a, b) -> a + b);

        maybe.subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }

    static void m2(){
        Single<Integer> single = ObservableSources.RANDOM_NUMBERS
                .reduce(100, (a, b) -> a + b);

        single.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}

