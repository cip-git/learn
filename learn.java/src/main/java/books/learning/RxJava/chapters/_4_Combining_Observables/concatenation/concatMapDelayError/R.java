package books.learning.RxJava.chapters._4_Combining_Observables.concatenation.concatMapDelayError;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

class R {

    public static void main(String[] args) {
        m();
    }

    static void m() {
        ObservableSources
                .RANDOM_NUMBERS
                .concatMapDelayError(R::map)
                .doFinally(() -> System.out.println("Finally"))
                .doOnComplete(() -> System.out.println("Complete"))
                .doOnTerminate(() -> System.out.println("Terminate"))
                .subscribe(
                        i -> System.out.println("Elem: " + i),
                        System.err::println,
                        () -> System.out.println("Complete 1"));
    }

    private static ObservableSource<Integer> map(Integer integer) {
        if (integer % 7 == 0) return Observable.error(new RuntimeException("Naspa " + integer));
        return Observable.just(integer);
    }
}
