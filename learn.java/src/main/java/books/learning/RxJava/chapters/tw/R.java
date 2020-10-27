package books.learning.RxJava.chapters.tw;

import static io.reactivex.Observable.range;
import static io.reactivex.Observable.timer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

class R {

    static void m() throws InterruptedException {
        final Observable<Long> timer = timer(3, TimeUnit.SECONDS);

        timer.subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(10);
    }

    static void m2(){
        final Observable<Integer> other = range(1, 10);
        other.subscribe(System.out::println);
    }

    static void m3() throws InterruptedException {
        range(1, 10)
                .delay(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(11);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
        m3();
    }
}
