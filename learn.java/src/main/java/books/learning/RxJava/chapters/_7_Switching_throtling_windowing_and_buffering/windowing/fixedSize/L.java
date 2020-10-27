package books.learning.RxJava.chapters._7_Switching_throtling_windowing_and_buffering.windowing.fixedSize;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

class L {

    public static final Function<Observable<Integer>, SingleSource<? extends String>> OBSERVABLE_SINGLE_SOURCE_FUNCTION = obs -> obs.reduce("", (total, nxt) -> total + (total.equals("") ? "" : "|") + nxt);

    static void m(){
        final Observable<Observable<Integer>> window = Observable
                .range(1, 50)
                .window(8);

        final Observable<String> observable = window
                .flatMapSingle(OBSERVABLE_SINGLE_SOURCE_FUNCTION);

        observable.subscribe(Util.printObserver());
    }

    static void m2(){
        Observable.range(1, 50)
                .window(2, 3)
                .flatMapSingle(OBSERVABLE_SINGLE_SOURCE_FUNCTION)
                .subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
        m();
//        m2();
    }
}
