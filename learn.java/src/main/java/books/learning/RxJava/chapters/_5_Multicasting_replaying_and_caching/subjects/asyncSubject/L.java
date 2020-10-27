package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.asyncSubject;

import books.learning.RxJava.chapters.Util;
import io.reactivex.subjects.AsyncSubject;

/**
 * AsyncSubject has a highly tailored, finite-specific behavior:
 * it will only push the last value it receives, followed by an onComplete() event
 */
class L {

    static void m(){
        final AsyncSubject<String> subject = AsyncSubject.<String>create();

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
