package books.learning.RxJava.chapters.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PrintObserver<T> implements Observer<T> {

    private final int nb;

    public PrintObserver(int nb) {
        this.nb = nb;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("Obs_" + nb + " | onSubscribe: " + disposable);
    }

    @Override
    public void onNext(T t) {
        System.out.println("Obs_" + nb + " | onNext: " + t + " | thread: " + Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Obs_" + nb + " | onError: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Obs_" + nb + " | onComplete ");
    }
}
