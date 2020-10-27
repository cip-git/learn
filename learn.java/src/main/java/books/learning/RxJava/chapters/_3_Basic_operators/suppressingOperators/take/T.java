package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.take;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class T {


    static void m(){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3).subscribe(System.out::println);
    }

    static void m2() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
