package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.startWith;

import io.reactivex.Observable;

class L {

    static Observable<String> source = Observable.just("Coffee", "Tea", "Espresso", "Latte");

    static void m(){
        source.startWith("Coffee shop menu")
                .subscribe(System.out::println);
    }

    static void m2(){
        source.startWithArray("Coffee shop menu", ".", "..", "..." )
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
