package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.replaySubject;

import books.learning.RxJava.chapters.Util;
import io.reactivex.subjects.ReplaySubject;

/**
 * ReplaySubject is similar to PublishSubject followed by a cache() operator.
 * It immediately captures emissions regardless of the presence of downstream Observers
 * and optimizes the caching to occur inside the Subject itself
 */
class L {

    static void m(){
        final ReplaySubject<String> subject = ReplaySubject.<String>create();

        subject.subscribe(Util.printObserver());

        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onComplete();

        subject.subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
        m();
    }
}
