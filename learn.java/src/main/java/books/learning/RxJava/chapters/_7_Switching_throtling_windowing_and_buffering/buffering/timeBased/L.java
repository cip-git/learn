package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.buffering.timeBased;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

class L {

    static void m() throws InterruptedException {
        final Observable<List<Long>> buffer = Observable
                .interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .buffer(1, TimeUnit.SECONDS);

        buffer.subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(4);
    }

    static void m2() throws InterruptedException {
        final Observable<List<Long>> buffer = Observable
                .interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .buffer(1, TimeUnit.SECONDS, 2);

        buffer.subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
