package books.learning.RxJava.chapters._3_Basic_operators.reducingOperators.contains;

import io.reactivex.Observable;
import io.reactivex.Single;

class L {

    static void m(){
        Single<Boolean> single = Observable.range(1, 100)
                .contains(343);

        single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    public static void main(String[] args) {
        m();
    }
}
