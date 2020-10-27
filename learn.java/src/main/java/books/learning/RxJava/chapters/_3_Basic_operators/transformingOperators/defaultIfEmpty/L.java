package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.defaultIfEmpty;

import io.reactivex.Observable;

class L {

    static void m(){
        Observable.just("Alpha","Beta","Gamma","Delta","Epsilon")
                .filter(s -> s.startsWith("Z"))
                .defaultIfEmpty("None")
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
