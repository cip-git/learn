package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.throttling;


import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import utils.print.Print;

import java.util.concurrent.TimeUnit;

/**
 * The buffer() and window() operators batch up emissions into collections or Observables based on a defined scope,
 * which regularly consolidates rather than omits emissions.
 * The throttle() operator, however, omits emissions when they occur rapidly.
 * This is helpful when rapid emissions are assumed to be redundant or unwanted,
 * such as a user clicking on a button repeatedly.
 * For these situations, you can use the throttleLast(), throttleFirst(),
 * and throttleWithTimeout() operators to only let the first or last element in a rapid sequence
 * of emissions through.
 */
class L {

    static final Observable<String> source = Observable
            .interval(100, TimeUnit.MILLISECONDS)
            .map(i -> (i + 1) * 100)  //map to elapsed time
            .map(i -> "Source " + i)
            .take(10);

    static final Observable<String> source2 = Observable
            .interval(300, TimeUnit.MILLISECONDS)
            .map(i -> (i + 1) * 300)
            .map(i -> "Source 2 " + i)
            .take(3);

    static final Observable<String> source3 = Observable
            .interval(2, TimeUnit.SECONDS)
            .map(i -> (i + 1) * 2000)
            .map(i -> "Source 3 " + i)
            .take(2);

    static void m() throws InterruptedException {
        Observable
                .concat(source, source2, source3)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(6);
    }

    /**
     * The throttleLast() operator (which is aliased as sample()) will only emit the last item
     * at a fixed time interval
     */
    static void m2() throws InterruptedException {
        Observable
                .concat(source, source2, source3)
                .throttleLast(1, TimeUnit.SECONDS)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(6);
    }

    /**
     * The throttleFirst() operates almost identically to throttleLast(),
     * but it will emit the first item that occurs at every fixed time interval
     */
    static void m3() throws InterruptedException {
        Observable
                .concat(source, source2, source3)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(6);
    }

    /**
     * throttleWithTimout() (also called debounce())
     * accepts time interval arguments that specify how long a period of inactivity
     * (which means no emissions are coming from the source) must be before the last emission
     * can be pushed forward.
     *
     * Think of Hollywood action movies where a protagonist is under heavy gunfire.
     * While bullets are flying, he/she has to take cover and is unable to act.
     * But the moment their attackers stop to reload, there is a period of silence where
     * they have time to react. This is essentially what throttleWithTimout() does.
     * While emissions are firing rapidly, it will not emit anything until there
     * is a "period of silence", and then it will push the last emission forward
     *
     */
    static void m4() throws InterruptedException {
        Observable
                .concat(source, source2, source3)
                .throttleWithTimeout(1, TimeUnit.SECONDS)
                .subscribe(Util.printObserver());

        TimeUnit.SECONDS.sleep(6);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
//        m3();
        m4();
    }
}
