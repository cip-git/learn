package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObservable.create;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class L {

    static void m() {
        Observable<String> source = Observable.create(emitter -> {
                    emitter.onNext("A");
                    emitter.onNext("B");
                    emitter.onNext("C");
                    emitter.onNext("D");
                    emitter.onNext("E");
                    emitter.onComplete();
                }
        );

        source.subscribe(System.out::println);
    }


    static void m2() {
        Observable<String> source = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("A");
                observableEmitter.onNext("B");
                observableEmitter.onNext("C");
                observableEmitter.onNext("D");
                observableEmitter.onNext("E");
                observableEmitter.onComplete();

            }
        });

        source.subscribe(System.out::println);
    }

    static void m3() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
            } catch (Throwable t) {
                emitter.onError(t);
            }
        });

        source.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    static void m4() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("a");
                emitter.onNext("b");
                emitter.onNext("c");

            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(i -> i > 0);

        filtered.subscribe(System.out::println);
    }

    static void m5() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("a");
            emitter.onNext("b");
            emitter.onNext("c");
        });

        source.map(String::length)
                .filter(i -> i > 0)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m3();
//        m4();
        m5();
    }
}
