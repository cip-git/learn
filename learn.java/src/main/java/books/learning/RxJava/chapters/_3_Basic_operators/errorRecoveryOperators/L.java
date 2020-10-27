package books.learning.RxJava.chapters._3_Basic_operators.errorRecoveryOperators;

import books.learning.RxJava.chapters.ObservableSources;

class L {

    static void m(){
        ObservableSources.RANDOM_NUMBERS_WITH_AE
                .map(i -> 10 % i)
                .subscribe(System.out::println, Throwable::printStackTrace, ()-> System.out.println("Done"));
    }

    public static void main(String[] args) {
        m();
    }
}
