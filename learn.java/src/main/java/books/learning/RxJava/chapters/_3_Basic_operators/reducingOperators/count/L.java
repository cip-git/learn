package books.learning.RxJava.chapters._3_Basic_operators.reducingOperators.count;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;

class L {

    static void m(){
        Single<Long> count = ObservableSources.GREEK_ALPHABET
                .count();
        count.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
