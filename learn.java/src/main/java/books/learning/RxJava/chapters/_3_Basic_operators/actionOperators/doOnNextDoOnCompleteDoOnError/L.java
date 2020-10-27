package books.learning.RxJava.chapters._3_Basic_operators.actionOperators.doOnNextDoOnCompleteDoOnError;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * The doOnNext() operator allows you to peek at each emission coming out of an operator
 * and going into the next.
 * This operator does not affect the operation or transform the emissions in any way
 * <p>
 * The doOnComplete() operator allows you to fire off an action when onComplete()
 * is called at the point in the Observable chain.
 * This can be helpful in seeing which points of the Observable chain have completed
 * <p>
 * doOnError() will peek at the error being emitted up the chain,
 * and you can perform an action with it.
 * This can be helpful to put between operators to see which one is to blame for an error
 */
class L {

    static void m() {
        ObservableSources.GREEK_ALPHABET
                .doOnNext(System.out::println)
                .map(String::length)
                .subscribe(System.out::println);
    }

    static void m2() {
        ObservableSources.GREEK_ALPHABET
                .doOnComplete(() -> System.out.println("Source has done emmiting"))
                .subscribe(System.out::println);
    }

    static void m3() {
        ObservableSources.RANDOM_NUMBERS_WITH_AE
                .doOnError(throwable -> System.out.println("Ups eroare"))
                .subscribe(System.out::println);
    }

    static void m4() {
        ObservableSources.GREEK_ALPHABET
                .doOnEach(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("s: " + s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Err ");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done ");
                    }
                })
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done 2"));
    }

    static void m5() {
        ObservableSources
                .RANDOM_NUMBERS
                .startWithArray(1, 2, 3, 0)
                .doOnError(t -> System.out.println("Source failed"))
                .doOnEach(i -> System.out.println("Elem: " + i))
                .map(i -> 10 % i)
                .doOnError(t -> System.out.println("Division failed"))
                .subscribe(
                        i -> System.out.println("onNext: " + i),
                        err -> System.out.println("Err: " + err.getMessage()));
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
