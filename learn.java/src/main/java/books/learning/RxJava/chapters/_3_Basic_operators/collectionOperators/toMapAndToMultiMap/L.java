package books.learning.RxJava.chapters._3_Basic_operators.collectionOperators.toMapAndToMultiMap;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class L {

    static void m() {
        Single<Map<Character, String>> single = ObservableSources.GREEK_ALPHABET
                .toMap(s -> s.charAt(0));

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m2() {
        Single<Map<Character, Integer>> mapSingle = ObservableSources.GREEK_ALPHABET
                .toMap(s -> s.charAt(0), String::length);

        Disposable subscribe = mapSingle.subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m3() {
        Single<Map<Character, Integer>> single = ObservableSources.GREEK_ALPHABET
                .toMap(s -> s.charAt(0), String::length, ConcurrentHashMap::new);

        single.subscribe(m -> System.out.println(m.getClass().getSimpleName()), Throwable::printStackTrace);
    }


    /**
     * if  a key maps to multiple emissions,
     * the last emission for that key is going to replace subsequent ones
     */
    static void m4() {
        Single<Map<Integer, String>> single = ObservableSources.GREEK_ALPHABET
                .repeat(5)
                .toMap(String::length);

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) {
//        m2();
//        m3();
        m4();
    }
}
