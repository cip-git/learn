package books.learning.RxJava.chapters._3_Basic_operators.collectionOperators.collect;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;

import java.util.HashSet;

class L {

    static void m(){
        Single<HashSet<String>> single = ObservableSources.GREEK_ALPHABET
                .repeat(4)
                .collect(HashSet::new, (s, e) -> s.add(e));

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) {
        m();
    }
}
