package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.takeWhileAndSkipWhile;

import io.reactivex.Observable;

class L {

    static void m() {
        Observable.range(1, 100)
                .takeWhile(i -> i < 5)
                .subscribe(System.out::println);
    }

    static void m2(){
        Observable.range(1, 100)
                .skipWhile(i -> i<5)
                .subscribe(System.out::println);
    }

    static void m3(){
        Observable.range(1, 100)
                .takeUntil(i -> i==5)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
