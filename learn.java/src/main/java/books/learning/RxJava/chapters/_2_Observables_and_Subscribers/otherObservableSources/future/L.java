package books.learning.RxJava.chapters._2_Observables_and_Subscribers.otherObservableSources.future;

import io.reactivex.Observable;
import io.reactivex.internal.subscribers.FutureSubscriber;

import java.util.concurrent.*;

class L {

    static Callable<String> callable = () -> "Callable";

    static Future<String> fs(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(callable);
        exec.shutdown();
        return future;
    }

    static void m(){
        Future<String> future = fs();

        Observable.fromFuture(future)
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
