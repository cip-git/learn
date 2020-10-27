package books.learning.RxJava.chapters._4_Combining_Observables.grouping;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.GroupedObservable;

import java.util.List;

class G {

    static final Observable<GroupedObservable<Integer, String>> groupBy = ObservableSources.GREEK_ALPHABET
            .groupBy(String::length);

    static void m() {
        groupBy.subscribe(new Observer<GroupedObservable<Integer, String>>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(GroupedObservable<Integer, String> integerStringGroupedObservable) {
                System.out.println(integerStringGroupedObservable.getKey() + " -> " + integerStringGroupedObservable);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }

    static void m2(){
        final Observable<List<String>> source = groupBy.flatMapSingle(s -> s.toList());

        source.subscribe(System.out::println);
    }

    static void m3(){
        final Observable<String> source = groupBy.flatMapSingle(grp -> grp.reduce("", (x, y) -> x.equals("") ? y : x + ", " + y)
                .map(s -> grp.getKey() + ": " + s));

        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
