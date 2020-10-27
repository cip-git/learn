package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObservable.just;


import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

class L {

    static void m(){

        Observable<String> source = Observable.just("a", "b", "c");

        source.map(String::length)
                .filter( i -> i>0)
                .subscribe(System.out::println);
    }

    static void m2(){
        List<String> lst = Arrays.asList("a", "b", "c");

        Observable<String> source = Observable.fromIterable(lst);
        source.map(String::length)
                .filter(i->i>0)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
