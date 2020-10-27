package books.learning.RxJava.chapters.util;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class PrintMaybeObserver<T> implements MaybeObserver<T> {

    private int nb;

    public PrintMaybeObserver(int nb) {
        this.nb = nb;
    }

    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("MaybeObserver_" + nb + " | onSubscribe: " + d);
    }

    @Override
    public void onSuccess(T t) {
        System.out.println("MaybeObserver_" + nb + " | onSuccess: " + t + " executed on thread: " + Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("MaybeObserver_" + nb + " | onError: " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("MaybeObserver_" + nb + " | onComplete()");
    }
}
