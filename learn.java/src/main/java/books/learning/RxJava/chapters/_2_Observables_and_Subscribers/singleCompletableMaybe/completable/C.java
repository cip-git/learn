package books.learning.RxJava.chapters._2_Observables_and_Subscribers.singleCompletableMaybe.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * Completable is simply concerned with an action being executed,
 * but it does not receive any emissions.
 * Logically, it does not have onNext() or onSuccess() to receive emissions,
 * but it does have onError() and onComplete()
 */
class C {
    static CompletableObserver observer = new CompletableObserver() {
        @Override
        public void onSubscribe(Disposable disposable) {
            System.out.println("onSubscribe: " + disposable);
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }
    };

    static void m(){
        Completable completable = Completable.fromRunnable(() -> runProcess());
        completable.subscribe(observer);
    }

    static void m2(){
        Completable complete = Completable.complete();
        complete.subscribe(observer);
    }

    private static void runProcess() {
        System.out.println("runProcess");
    }

    public static void main(String[] args) {
        m();
        System.out.println();
        m2();
    }
}
