package books.learning.RxJava.chapters._3_Basic_operators.transformingOperators.map;

import io.reactivex.Observable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class M {

    static void m(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");

        Observable
                .just("1/3/2016", "5/9/2016", "10/12/2016")
                .map(s-> LocalDate.parse(s, dtf))
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
