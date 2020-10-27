package books.learning.RxJava.chapters._4_Combining_Observables.combileLatest;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * The Observable.combineLatest() factory is somewhat similar to zip(),
 * but for every emission that fires from one of the sources,
 * it will immediately couple up with the latest emission from every other source.
 * It will not queue up unpaired emissions for each source,
 * but rather cache and pair the latest one.
 */
class CL {

    static void m() throws InterruptedException {
        final Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS);
        final Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable
                .combineLatest(source, source2, (l, l2) -> "Source: " + l + " | Source2: " + l2)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
