package books.learning.RxJava.chapters._3_Basic_operators.collectionOperators.toMapAndToMultiMap;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;

import java.util.Collection;
import java.util.Map;

class L2 {

    static void m(){
        Single<Map<Character, Collection<String>>> single = ObservableSources.GREEK_ALPHABET
                .repeat(3)
                .toMultimap(s -> s.charAt(0));

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m2(){
       ObservableSources.GREEK_ALPHABET
                .repeat(3)
                .toMultimap(s -> s.charAt(0), String::length)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
