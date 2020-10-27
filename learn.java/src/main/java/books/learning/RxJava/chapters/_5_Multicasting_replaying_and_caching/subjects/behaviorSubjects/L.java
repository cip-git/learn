package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.behaviorSubjects;

import books.learning.RxJava.chapters.Util;
import books.learning.RxJava.chapters.util.PrintObserver;
import io.reactivex.subjects.BehaviorSubject;
import utils.print.Print;

/**
 * Aside from the commonly used PublishSubject, there is also BehaviorSubject.
 * It behaves almost the same way as PublishSubject, but it will replay the last emitted item
 * to each new Observer downstream.
 * This is somewhat like putting replay(1).autoConnect() after a PublishSubject,
 * but it consolidates these operations into a single optimized Subject implementation
 * that subscribes eagerly to the source:
 */
class L {

    static void m() {
        final BehaviorSubject<String> subject = BehaviorSubject.<String>create();

        subject.subscribe(Util.printObserver());

        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");

        subject.subscribe(Util.printObserver());
    }

    public static void main(String[] args) {
        m();
    }
}
