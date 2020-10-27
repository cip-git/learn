package books.learning.RxJava.chapters;

import books.learning.RxJava.chapters.util.PrintMaybeObserver;
import books.learning.RxJava.chapters.util.PrintObserver;
import books.learning.RxJava.chapters.util.PrintSingleObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public interface Util {
    AtomicInteger ATOMIC_INTEGER = new AtomicInteger(1);

    static <T> Observer<T> printObserver(){
        return new PrintObserver<>(ATOMIC_INTEGER.getAndIncrement());
    }


    static SingleObserver<Integer> printIntegerSingleObserver(){
        return new PrintSingleObserver<Integer>(ATOMIC_INTEGER.getAndIncrement());
    }

    static int randomInt(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }

    static <T> T intenseCalculation(T t ){
        final int nextInt = ThreadLocalRandom.current().nextInt(3000);
        try {
            TimeUnit.MILLISECONDS.sleep(nextInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t;
    }

    static <T> MaybeObserver<T> printMaybeObserver() {
        return new PrintMaybeObserver<>(ATOMIC_INTEGER.getAndIncrement());
    }
}
