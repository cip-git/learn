package books.learning.RxJava.chapters._3_Basic_operators.reducingOperators.all;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

class L {

    static void m(){
        Single<Boolean> single = ObservableSources.RANDOM_NUMBERS
                .all(i -> i > 5);

        single.subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                System.out.println(aBoolean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public static void main(String[] args) {
        m();
    }
}
