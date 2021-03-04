package books.learning.RxJava.chapters._3_Basic_operators.errorRecoveryOperators.onErrorResumeNext;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

class L {

    static void m() {
        final Observable<Integer> otherSource = ObservableSources.GREEK_ALPHABET.map(String::length);

        ObservableSources.RANDOM_NUMBERS_WITH_AE
                .onErrorResumeNext(otherSource)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    static void m2() {
        ObservableSources.RANDOM_NUMBERS_WITH_AE
                .onErrorResumeNext((Throwable err) -> Observable.just(-77))
                .doOnError(i -> System.out.println("Err on: " + i))
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    static void m3(){
        ObservableSources
                .RANDOM_NUMBERS_WITH_AE
                .onErrorResumeNext(( Throwable t)->Observable.just(-300))
                .filter(e -> e!= null)
                .subscribe(System.out::println, t->{}, () -> System.out.println("Done"));
    }

    static void m4() throws InterruptedException {
        Single
                .just("a")
                .subscribeOn(Schedulers.io())
                .flatMap(L::transform)
                .doOnSuccess(L::onSuccess)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(1);
    }

    private static SingleSource<String>  onSuccess(String s) {
        final String item = s.toUpperCase();
        System.out.println(item);
        return Single.just(item);
    }

    static Observable<String> m5(){
        ObservableSources
                .NUMBER_WITH_AE
                .subscribe(
                        i -> System.out.println("i:" + i),
                        err -> System.out.println(err.getMessage()),
                        () -> Observable.just("Ok"));
        return Observable.just("nOK");
    }

    static void m6(){
        m5()
                .subscribe(
                        a -> System.out.println("m6: " + a),
                        err -> System.out.println("m6 err"),
                        () ->  System.out.println("m6 complete"));
    }

    private static SingleSource<String> transform(String s) {
        return Single.just(s + " " + s);
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();
//        m3();
//        m4();
        m6();
    }
}
