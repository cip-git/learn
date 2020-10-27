package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.sorted;

import io.reactivex.Observable;

import java.util.Comparator;

class L {

    static Observable<Integer> source = Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3);

    static void m() {
        source.sorted()
                .subscribe(System.out::println);
    }

    static void m2() {
        source
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}

