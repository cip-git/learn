package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.introducingRxJavaConcurrecny;


import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;


class L2 {

    static void m(){
        ObservableSources.ALPHABET
                .map(Util::intenseCalculation)
                .subscribe(Util.printObserver());


        Observable.range(1, 6)
                .map(Util::intenseCalculation)
                .subscribe(Util.printObserver());
    }

    static void m2() throws InterruptedException {
        ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation)
                .subscribe(Util.printObserver());

        Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(5);
    }

    static void m3() throws InterruptedException {
        final Observable<String> source = ObservableSources.ALPHABET
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation);

        final Observable<Integer> source2 = Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(Util::intenseCalculation);

        Observable.zip(source, source2, (s, i) -> s + " - " + i)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(10);

    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
        m3();
    }
}
