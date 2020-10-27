package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.delay;


import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class L {

    static Observable<String> source = Observable.just("Alpha", "Beta", "Gamma" ,"Delta","Epsilon");

    static void m() throws InterruptedException {
        source
                .delay(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(4);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
