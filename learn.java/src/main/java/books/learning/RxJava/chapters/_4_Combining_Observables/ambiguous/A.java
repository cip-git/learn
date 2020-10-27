package books.learning.RxJava.chapters._4_Combining_Observables.ambiguous;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * The Observable.amb() factory (amb stands for ambiguous) will accept an
 * Iterable<Observable<T>> and emit the emissions of the first Observable that emits,
 * while the others are disposed of.
 * The first Observable with an emission is the one whose emissions go through.
 * This is helpful when you have multiple sources for the same data or events and
 * you want the fastest one to win
 */
class A {

    static void m() throws InterruptedException {
        final Observable<String> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(2)
                .map(i -> i + 1)
                .map(i -> "Source: " + i + " sec");

        final Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .map(i -> "Source2: " + i + " miliSec");

        Observable.amb(Arrays.asList(source, source2))
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
