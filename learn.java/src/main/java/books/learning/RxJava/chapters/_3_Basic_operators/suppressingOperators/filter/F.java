package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.filter;

import io.reactivex.Observable;

class F {

    static void m(){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .filter(s ->s.length()>4)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
