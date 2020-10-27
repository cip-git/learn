package books.learning.RxJava.chapters._3_Basic_operators.collectionOperators.toList;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class L {

    static void m() {
        Single<List<String>> single = ObservableSources.GREEK_ALPHABET
                .toList();

        Disposable disposable = single.subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m2() {
        Single<List<Integer>> single = Observable.range(1, 100)
                .toList();

        Disposable disposable = single
                .subscribe(l -> Observable.fromIterable(l).reduce((a, b) -> a + b).subscribe(new MaybeObserver<Integer>() {
                            @Override
                            public void onSubscribe(Disposable disposable) {
                                System.out.println("onSubscribe");
                            }

                            @Override
                            public void onSuccess(Integer integer) {
                                System.out.println(integer);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                throwable.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("onComplete");
                            }
                        }),
                        Throwable::printStackTrace);
        System.out.println(disposable.isDisposed());
    }

    static void m3() {
        ObservableSources.GREEK_ALPHABET
                .toList(CopyOnWriteArrayList::new)
                .subscribe(l -> System.out.println(l.getClass().getSimpleName()), Throwable::printStackTrace);
    }

    static void m4() {
        ObservableSources.GREEK_ALPHABET
                .toList(ArrayDeque::new)
                .subscribe(c -> System.out.println(c.getClass().getSimpleName()), Throwable::printStackTrace);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
