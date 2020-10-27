package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.cast;

import io.reactivex.Observable;

class C {

    static Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");

    static void m(){
        source.map(s -> (Object) s)
                .subscribe(System.out::println);

        source.cast(Object.class)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }

}
