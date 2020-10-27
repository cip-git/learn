package books.learning.RxJava.chapters._5_Multicasting_replaying_and_caching.subjects.whenSubjectsGoWrong;


import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Since Subjects are hot, executing the onNext() calls before the Observers are set up
 * would result in these emissions being missed with our Subject. If you move the onNext()
 * calls like this, you will not get any output because the Observer will miss these emissions:
 */
class L {

    static void m(){
        Subject<String> subject = PublishSubject.create();
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onComplete();

        subject
                .map(String::length)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
