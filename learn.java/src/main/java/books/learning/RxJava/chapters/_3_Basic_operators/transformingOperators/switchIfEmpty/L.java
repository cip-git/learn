package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.switchIfEmpty;


import io.reactivex.Observable;

class L {

    static Observable<String> source = Observable.just("a", "b", "c");
    static Observable<String> soorce2 = source.map(String::toUpperCase);

    static void m(){
        source.filter(s -> s.charAt(0) < 'a' )
                .switchIfEmpty(soorce2)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
