package books.learning.RxJava.chapters.util;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PrintSingleObserver<T> implements SingleObserver<T> {
    private final int nb;

    public PrintSingleObserver(int nb) {
        this.nb = nb;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("Obs_" + nb + " | onSubscribe: " + disposable);
    }

    @Override
    public void onSuccess(T t) {
        System.out.println("Obs_" + nb + " | onSuccess: " + t);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Obs_" + nb + " | onError: " + throwable.getMessage());
    }
}
