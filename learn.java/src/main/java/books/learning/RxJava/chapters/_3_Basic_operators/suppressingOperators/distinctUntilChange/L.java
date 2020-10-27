package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.distinctUntilChange;

import io.reactivex.Observable;

class L {

    static void m(){
        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    static void m2(){
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
