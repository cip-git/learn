package books.learning.RxJava.chapters._2_Observables_and_Subscribers.coldVsHotObservables.cold;

import io.reactivex.Observable;

/**
 * Cold Observables are much like a music CD that can be replayed to each listener,
 * so each person can hear all the tracks at any time.
 * In the same manner, cold Observables will replay the emissions to each Observer,
 * ensuring that all Observers get all the data
 */
class L {

    static Observable<String> source = Observable.just("A", "B", "C");

    static void m(){

        System.out.println("Cold observers: ");
        source.subscribe(System.out::println);
        System.out.println("Second observer");
        source.subscribe(System.out::println);
    }

    static void m2(){
        source.map(String::toLowerCase)
                .subscribe(System.out::println);

        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
