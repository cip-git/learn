package books.learning.RxJava.chapters._1_Think_reactively.quickExposure;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

class Launcher {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("A", "B", "C", "D");

        Disposable subscribe = observable
                .map(String::length)
                .subscribe(System.out::println);
        System.out.println(subscribe);
    }
}
