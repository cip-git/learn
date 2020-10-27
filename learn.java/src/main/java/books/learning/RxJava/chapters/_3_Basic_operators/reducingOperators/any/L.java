package books.learning.RxJava.chapters._3_Basic_operators.reducingOperators.any;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Single;

class L {

    static void m(){
        Single<Boolean> single = ObservableSources.RANDOM_NUMBERS
                .any(i -> i > 5);

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) {
        m();
    }
}
