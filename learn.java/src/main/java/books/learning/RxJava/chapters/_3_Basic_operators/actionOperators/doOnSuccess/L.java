package books.learning.RxJava.chapters._3_Basic_operators.actionOperators.doOnSuccess;

import books.learning.RxJava.chapters.ObservableSources;

class L {

    static void m(){
        ObservableSources
                .RANDOM_NUMBERS
                .reduce((a, b) -> a + b)
                .doOnSuccess(i -> System.out.println("Emitting: " + i))
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace);
    }

    public static void main(String[] args) {
        m();
    }
}
