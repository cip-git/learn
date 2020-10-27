package books.learning.RxJava.chapters._2_Observables_and_Subscribers.disposing.handlingADisposableWithinAnObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

class L {

    static Observer<Integer> observer = new Observer<Integer>() {
        private Disposable disposable;

        @Override
        public void onSubscribe(Disposable disposable) {
            this.disposable = disposable;
        }

        @Override
        public void onNext(Integer integer) {
            //has access to the disposable
            System.out.println(integer);
            disposable.dispose();
        }

        @Override
        public void onError(Throwable throwable) {
            //has access to the disposable
        }

        @Override
        public void onComplete() {
            //has access to the disposable
        }
    };

    static ResourceObserver<Long> resourceObserver = new ResourceObserver<Long>() {
        @Override
        public void onNext(Long aLong) {
            System.out.println(aLong);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("Done");
        }
    };

    static void m2() throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> observer = source.subscribeWith(resourceObserver);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(observer.isDisposed());
    }

    static void m(){
        Observable<Integer> source = Observable.range(1, 5);

        source.subscribe(observer);  //it should stop after the first elem
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
        m2();
    }
}
