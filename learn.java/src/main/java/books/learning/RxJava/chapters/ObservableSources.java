package books.learning.RxJava.chapters;


import io.reactivex.Observable;

public class ObservableSources {

    public static final Observable<String> GREEK_ALPHABET = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    public static final Observable<String> ALPHABET = Observable.just("A", "B", "C", "D", "E");
    public static final Observable<Integer> RANDOM_NUMBERS = Observable.just(5, 3, 7, 10, 2, 14);
    public static final Observable<Integer> RANDOM_NUMBERS_WITH_AE =
            Observable
                    .just(5, 3, 7,  0, 10, 2, 14, 0)
                    .map(i -> {
                        final var m = Short.MAX_VALUE % i;
                        return i;
                    });
}
