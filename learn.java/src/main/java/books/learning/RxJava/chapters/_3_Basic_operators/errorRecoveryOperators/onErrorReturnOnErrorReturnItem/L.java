package books.learning.RxJava.chapters._3_Basic_operators.errorRecoveryOperators.onErrorReturnOnErrorReturnItem;

import books.learning.RxJava.chapters.ObservableSources;

class L {

    static void m() {
        ObservableSources.RANDOM_NUMBERS_WITH_AE.onErrorReturn(i -> -7)  //no more item are processed after thi.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
        .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    static void m2(){
        ObservableSources
                .RANDOM_NUMBERS_WITH_AE
                .onErrorReturnItem(-77)
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
