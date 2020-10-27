package books.learning.RxJava.chapters._3_Basic_operators.actionOperators.doOnSubscribeDoOnDispose;

import books.learning.RxJava.chapters.ObservableSources;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class L {

    static void m(){
        ObservableSources.GREEK_ALPHABET
                .doOnSubscribe( d -> System.out.println(d.hashCode()))
                .doOnDispose(()-> System.out.println("Disposing"))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("On Subscribe: " + disposable.hashCode());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    public static void main(String[] args) {
        m();
    }
}
