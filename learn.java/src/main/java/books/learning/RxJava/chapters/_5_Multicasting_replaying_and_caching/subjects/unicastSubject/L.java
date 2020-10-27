package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.unicastSubject;

import books.learning.RxJava.chapters.Util;
import io.reactivex.Observable;
import io.reactivex.subjects.UnicastSubject;
import utils.resources.files.print.Print;

import java.util.concurrent.TimeUnit;

/**
 * A UnicastSubject, like all Subjects, will be used to observe and subscribe to the sources.
 * But it will buffer all the emissions it receives until an Observer subscribes to it,
 * and then it will release all these emissions to the Observer and clear its cache.
 *
 * It will only work with one Observer and will throw an error for any subsequent ones.
 * Logically, this makes sense because it is designed to release buffered emissions from
 * its internal queue once it gets an Observer. But when these cached emissions are released,
 * they cannot be released again to a second Observer since they are already gone.
 * If you want a second Observer to receive missed emissions, you might as well use ReplaySubject. The benefit of UnicastSubject is that it clears its buffer, and consequently frees the memory used for that buffer, once it gets an Observer.
 */
class L {

    static void m() throws InterruptedException {
        final UnicastSubject<String> subject = UnicastSubject.<String>create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300 + " miliseconds"))
                .subscribe(subject);

        TimeUnit.SECONDS.sleep(2);

        subject.subscribe(Util.printObserver());
    }

    static void m2() throws InterruptedException {
        final UnicastSubject<String> subject = UnicastSubject.<String>create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1)*300) + " miliseconds")
                .subscribe(subject);

        final Observable<String> multicast = subject
                .publish()
                .autoConnect();

        multicast.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(2);

        multicast.subscribe(Util.printObserver());
        TimeUnit.SECONDS.sleep(1);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
