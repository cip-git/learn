package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.disctinct;

import io.reactivex.Observable;

class D {

    static void m(){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(String::length)
                .distinct()
                .subscribe(System.out::println);
    }

    static void m2(){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
