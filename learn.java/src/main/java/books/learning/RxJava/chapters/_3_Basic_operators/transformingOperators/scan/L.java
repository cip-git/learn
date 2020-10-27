package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.scan;

import io.reactivex.Observable;

class L {

    static Observable<Integer> source = Observable.just(5, 3, 7, 10, 2, 14);

    static void m(){
        source.scan((accumulator, next) -> accumulator+next)
                .subscribe(System.out::println);
    }

    static void m2(){
        source.scan(10, (acc, nxt) -> acc+nxt)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
