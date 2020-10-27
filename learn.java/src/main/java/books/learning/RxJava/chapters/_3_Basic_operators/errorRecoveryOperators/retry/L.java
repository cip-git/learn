package books.learning.RxJava.chapters._3_Basic_operators.errorRecoveryOperators.retry;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;

class L {

    static Observable<Integer> source = ObservableSources.RANDOM_NUMBERS_WITH_AE;

    static void m() {
        source
                .retry() //tries undefinetely
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }


    static void m2() {
        source
                /**
                 * Retries 2 times and then throws the error
                 */
                .retry(2)
                .subscribe(System.out::println);
    }

    static void m3() {
        source
                .retry(2)
                .onErrorReturnItem(-77)
                .subscribe(System.out::println);
    }

    static void m4() {
        source
                .retry(throwable -> !(throwable instanceof ArithmeticException))
                .subscribe(System.out::println);
    }

    static void m5() {
        source
                .retry(2, throwable -> throwable instanceof ArithmeticException)
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
