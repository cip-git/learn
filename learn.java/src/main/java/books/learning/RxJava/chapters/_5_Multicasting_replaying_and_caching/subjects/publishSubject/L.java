package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.publishSubject;

import books.learning.RxJava.chapters.Util;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 *Those are a couple of implementation of Subject - abstract type,
 * extends Observable, implements Observer.
 *
 * This means that you can manually call
 * onNext()
 * onComplete()
 * onError()
 * and will, in turn, pass those events downstream towards its Observers
 *
 */
class L {

    static void m(){
        final Subject<String> subject = PublishSubject.<String>create();

        subject.map(String::toUpperCase)
                .subscribe(Util.printObserver());

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
    }

    public static void main(String[] args) {
        m();
    }
}
