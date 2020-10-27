package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.serializingSubjects;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * A critical gotcha to note with Subjects is this:
 * the onSubscribe(), onNext(), onError(), and onComplete() calls are not threadsafe!
 *
 * If you have multiple threads calling these four methods, emissions could start to overlap
 * and break the Observable contract, which demands that emissions happen sequentially.
 * If this happens, a good practice to adopt is to call toSerialized() on Subject to yield
 * a safely serialized Subject implementation (backed by the private SerializedSubject).
 * This will safely sequentialize concurrent event calls so no train wrecks occur downstream:
 */
class L {

    static void m(){
        Subject<String> subject =
                PublishSubject.<String>create().toSerialized();
    }
}
