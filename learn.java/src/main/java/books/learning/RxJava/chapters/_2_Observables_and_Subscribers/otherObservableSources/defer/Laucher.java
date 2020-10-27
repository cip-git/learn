package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.defer;

import io.reactivex.Observable;

class Laucher {

    private static int start = 1;
    private static int count = 5;

    static void need(){

        Observable<Integer> source = Observable.range(start, count);

        source.subscribe(System.out::println);

        count = 10;

        System.out.println("cont has a new value:  " + count);
        source.subscribe(System.out::println);
    }

    static void solution(){

        Observable<Integer> source = Observable.defer(()-> Observable.range(start, count));

        source.subscribe(System.out::println);

        count = 10;
        System.out.println("count has a new value: " + count);
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        need();
        solution();
    }
}
