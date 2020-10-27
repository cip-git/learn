package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.repeat;

import io.reactivex.Observable;

class L {

    static Observable<String> source= Observable.just("Alpha", "Beta", "Gamma" ,"Delta", "Epsilon");

    static void m(){
        source.repeat(2)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
