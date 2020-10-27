package books.learning.RxJava.chapters._4_Combining_Observables.combileLatest.withLatestFrom;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * withLatestfrom() operator will map each T emission with the latest values
 * from other Observables and combine them, but it will only take one emission
 * from each of the other Observables
 */
class L {

    static final Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS);
    static final Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

    static void m() throws InterruptedException {


        source2.withLatestFrom(source, (l, l2) -> "Source2: " + l + " | Source: " + l2)
                .subscribe(System.out::println);


        TimeUnit.SECONDS.sleep(3);
    }

    static void m2() throws InterruptedException {
        source.withLatestFrom(source2, (l, l2) -> "Source: " + l + " | Source2: " + l2)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
