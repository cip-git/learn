package books.learning.RxJava.chapters._4_Combining_Observables.merging.flatMap;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * The Observable.merge() operator will accept a fixed number of Observable sources.
 * But flatMap() will dynamically keep adding new Observable sources for each emission
 * that comes in. This means that you can keep merging new incoming Observables over time.
 */
class FM {

    static void m() {
        final Observable<String> source =
                ObservableSources
                        .GREEK_ALPHABET
                        .flatMap(s -> Observable.fromArray(s.split("")));

        source
                .distinct()
                .subscribe(System.out::println);
    }

    static void m2() {
        Observable<String> source =
                Observable
                        .just(
                                "521934/2342/FOXTROT",
                                "21962/12112/78886/TANGO",
                                "283242/4542/WHISKEY/2348562");

        source
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .subscribe(System.out::println);
    }

    static void m3() throws InterruptedException {
        Observable<Integer> intervalArgs = Observable.just(2, 3, 10, 7);

        intervalArgs
                .flatMap(
                        i ->
                                Observable
                                        .interval(i, TimeUnit.SECONDS)
                                        .map(j -> i + " s interval: " + ((i + 1) * i) + " seconds elapsed"))
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(12);
    }

    static void m4() throws InterruptedException {
        final Observable<Integer> secondsInterval = Observable.just(2, 3, 0, 10, 7);

        secondsInterval
                .flatMap(i -> {
                    if (i == 0)
                        return Observable.empty();
                    else
                        return Observable
                                .interval(i, TimeUnit.SECONDS)
                                .map(l -> i + "s interval: " + ((l + 1) * i) + " seconds elapsed");
                })
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(12);
    }

    static void m5() {
        ObservableSources
                .GREEK_ALPHABET
                .flatMap(
                        s -> Observable.fromArray(s.split("")), (s, r) -> s + "-" + r)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
//        m3();
//        m4();
//        m5();
    }
}
