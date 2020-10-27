package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.buffering.fixedSize;


import io.reactivex.Observable;

import java.util.HashSet;
import java.util.List;

/**
 * The buffer() operator will gather emissions within a certain scope and emit each
 * batch as a list or another collection type.
 * The scope can be defined by a fixed buffer sizing or a
 * timing window that cuts off at intervals
 * or even slices by the emissions of another Observable.
 */
class L {

    static void m(){
        final Observable<List<Integer>> buffer = Observable.range(1, 50)
                .buffer(8);

        buffer.subscribe(System.out::println);
    }

    static void m2(){
        final Observable<HashSet<Integer>> buffer = Observable.range(1, 50)
                .buffer(8, HashSet::new);

        buffer.subscribe(System.out::println);
    }

    static void m3(){
        final Observable<List<Integer>> buffer = Observable.range(1, 10)
                .buffer(2, 3);
        buffer.subscribe(System.out::println);
    }

    static void m4(){
        final Observable<List<Integer>> buffer = Observable.range(1, 10)
                .buffer(3, 2);
        buffer.subscribe(System.out::println);
    }

    static void m5(){
        Observable.range(1, 10)
                .buffer(3, 3)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
//        m5();
    }
}
