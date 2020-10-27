package books.learning.RxJava.chapters._2_Observables_and_Subscribers.coldVsHotObservables.connected;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * A helpful form of hot Observable is ConnectableObservable.
 * It will take any Observable, even if it is cold, and make it hot
 * so that all emissions are played to all Observers at once.
 * To do this conversion, you simply need to call publish() on any Observable,
 * and it will yield a ConnectableObservable.
 * But subscribing will not start the emissions yet.
 * You need to call its connect() method to start firing the emissions.
 * This allows you to set up all your Observers beforehand.
 */
class L {

    static void m(){
        ConnectableObservable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon").publish();

        source.subscribe(s -> System.out.println("Subscriber 1: " + s));
        source.map(String::toUpperCase).subscribe(s -> System.out.println("Subscriber 2: " + s));

        source.connect();
    }

    public static void main(String[] args) {
        m();
    }
}
