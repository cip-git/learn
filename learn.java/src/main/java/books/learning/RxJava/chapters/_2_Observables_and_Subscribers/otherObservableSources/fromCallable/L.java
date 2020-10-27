package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.fromCallable;

import io.reactivex.Observable;

class L {

    static void problem(){
        Observable.just(1/0)
                .subscribe(System.out::println,
                        e -> System.out.println("Err: " + e.getMessage()));
    }

    static void solution(){
        Observable.fromCallable(()->1/0)
                .subscribe(System.out::println,
                        System.err::println);
    }

    public static void main(String[] args) {
//        problem();
        solution();
    }

}
