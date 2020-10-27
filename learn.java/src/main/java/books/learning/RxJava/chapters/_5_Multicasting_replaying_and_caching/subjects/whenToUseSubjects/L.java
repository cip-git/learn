package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.whenToUseSubjects;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.sql.Time;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * More likely, you will use Subjects to eagerly subscribe to an unknown number
 * of multiple source Observables and consolidate their emissions as a single Observable.
 * Since Subjects are an Observer, you can pass them to a subscribe() method easily.
 *
 * This can be helpful in modularized code bases where decoupling between
 * Observables and Observers takes place and executing Observable.merge()
 * is not that easy.
 *
 * Another note to make is that the first Observable to call onComplete() on Subject is going to
 * cease other Observables from pushing their emissions,
 * and downstream cancellation requests are ignored. T
 *
 * his means that you will most likely use Subjects for infinite,
 * event-driven (that is, user action-driven) Observables.
 *
 * Here, I use Subject to merge and multicast two Observable interval sources:
 */
class L {

    static void m() throws InterruptedException {
        Observable<String> source =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(l -> (l + 1) + " seconds");

        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> ((l + 1) * 300) + " milliseconds");

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(System.out::println);

        source.subscribe(subject);
        source2.subscribe(subject);

        subject.onNext("bla bla");

        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
