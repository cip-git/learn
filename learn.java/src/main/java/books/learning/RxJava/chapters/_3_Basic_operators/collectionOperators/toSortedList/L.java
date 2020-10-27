package books.learning.RxJava.chapters._3_Basic_operators.collectionOperators.toSortedList;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Comparator;
import java.util.List;

class L {

    static void m() {
        Single<List<String>> single = ObservableSources.GREEK_ALPHABET
                .toSortedList();

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m2() throws InterruptedException {
        Single<List<Integer>> single = Observable.range(1, 100)
                .toSortedList(Comparator.reverseOrder());

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) throws InterruptedException {
        m2();
    }
}
