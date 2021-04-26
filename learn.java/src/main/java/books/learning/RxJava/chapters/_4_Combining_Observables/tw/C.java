package books.learning.RxJava.chapters._4_Combining_Observables.tw;

import static books.learning.RxJava.chapters.ObservableSources.NUMBER;
import static books.learning.RxJava.chapters.ObservableSources.RANDOM_NUMBERS_WITH_AE;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Completable;
import io.reactivex.Observable;

class C {

    static void m(){

        final List<Completable> completables = List
                .of(1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 10, 0)
                .stream()
                .map(i -> Observable
                        .just(i)
                        .map(j -> {
                            System.out.println("Elem: " + j);
                            return Short.MAX_VALUE % j;
                        })
                        .doOnError(err -> System.out.println("Error on: " + i)))
                .map(Completable::fromObservable)
                .collect(toList());

        final Completable completable = Completable
                .mergeDelayError(completables)
                .doAfterTerminate(() -> System.out.println("doAfterTerminate"))
                .doOnError(err -> System.out.println("Err: " + err.getMessage()));


        completable
                .subscribe(
                        () -> System.out.println("On Complete"),
                        err -> System.out.println("Last err: " + err.getMessage()));
    }

    public static void main(String[] args) {
        m();
    }
}
