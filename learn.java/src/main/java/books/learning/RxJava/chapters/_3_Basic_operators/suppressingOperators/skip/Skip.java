package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.skip;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class Skip {

    static void m(){
        Observable.range(1, 100)
                .skip(90)
                .subscribe(System.out::println);
    }

    static void m2() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .skip(3, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
