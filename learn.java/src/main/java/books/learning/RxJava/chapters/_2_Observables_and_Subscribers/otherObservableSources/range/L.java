package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.range;

import io.reactivex.Observable;

class L {

    static void m(){
        Observable.range(1, 10).subscribe(System.out::println);
    }

    static void m2(){
        Observable.range(5, 10).subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
