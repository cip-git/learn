package books.learning.RxJava.chapters._1_Think_reactively.quickExposure;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class Laucher_2 {

    static void m() throws InterruptedException {
        Observable<Long> intervals = Observable.interval(1, TimeUnit.SECONDS);

        intervals.subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
