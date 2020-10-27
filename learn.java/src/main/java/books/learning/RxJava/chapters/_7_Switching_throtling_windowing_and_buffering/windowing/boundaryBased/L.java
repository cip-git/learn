package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.windowing.boundaryBased;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

class L {

    static final Function<Observable<Long>, SingleSource<? extends String>> OBSERVABLE_SINGLE_SOURCE_FUNCTION = obs -> obs.reduce("", (total, nxt) -> total + (total.equals("") ? "" : "|") + nxt);

    static void m() throws InterruptedException {
        final Observable<Observable<Long>> window = Observable
                .interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .window(Observable.interval(1, TimeUnit.SECONDS));

        window
                .flatMapSingle(OBSERVABLE_SINGLE_SOURCE_FUNCTION)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
