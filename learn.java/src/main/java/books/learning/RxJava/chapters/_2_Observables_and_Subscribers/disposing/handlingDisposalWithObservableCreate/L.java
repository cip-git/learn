package books.learning.RxJava.chapters._2_Observables_and_Subscribers.disposing.handlingDisposalWithObservableCreate;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class L {

    static void m() {
        Observable<Integer> source = Observable.create(emitter -> {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!emitter.isDisposed()) {
                        emitter.onNext(i);
                    }
                    if (emitter.isDisposed()) {
                        return;
                    }
                }
                emitter.onComplete();
            } catch (Throwable t) {
                emitter.onError(t);
            }
        });
    }

    static void m2() {
        Observable<Integer> source = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(i);
                        }
                        if (observableEmitter.isDisposed()) {
                            return;
                        }
                        observableEmitter.onComplete();
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

}
