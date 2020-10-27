package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understabdingSchedulers.executorService;

import books.learning.RxJava.chapters.ObservableSources;
import books.learning.RxJava.chapters.Util;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * You can build a Scheduler off a standard Java ExecutorService.
 * You may choose to do this in order to have more custom and fine-tuned control over your
 * thread management policies.
 * For example, say, we want to create a Scheduler that uses 20 threads.
 * We can create a new fixed ExecutorService specified with this number of threads.
 * Then, you can wrap it inside a Scheduler implementation by calling Schedulers.from()
 */
class L {

    int nbOfThreads = 20;

    static void m(){
        ExecutorService exec = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(exec);

        ObservableSources.ALPHABET
                .subscribeOn(scheduler)
                .doFinally(exec::shutdown)
                .subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
        m();
    }
}
