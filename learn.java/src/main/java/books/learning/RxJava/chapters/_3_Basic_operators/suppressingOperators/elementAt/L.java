package books.learning.RxJava.chapters._3_Basic_operators.suppressingOperators.elementAt;

import io.reactivex.Maybe;
import io.reactivex.Observable;

class L {
    static void m() {
        Observable<String> source = Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta");

        Maybe<String> stringMaybe = source.elementAt(3);
        stringMaybe.subscribe(System.out::println);


        Maybe<String> stringMaybe2 = source.elementAt(7);
        stringMaybe2.subscribe(System.out::println);

        System.out.println("Done");
    }

    public static void main(String[] args) {
        m();
    }
}
