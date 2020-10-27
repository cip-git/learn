package oc.p._8._4_FunctionalProgramming.returningAnOptional;

import java.util.Optional;
import java.util.function.Supplier;

class OptionalUse {

    static Optional<Double> valid, empty, temp;

    static {
        valid = avg(90, 100);
        empty = avg();
    }

    static Optional<Double> avg(int... nbs) {
        if(nbs.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for(int i : nbs) {
            sum += i;
        }
        return Optional.of((double) sum / nbs.length);
    }

    static void m() {
        System.out.println(valid);  //Optional[95.0]
        System.out.println(empty);  //Optional.empty
    }

    static void get(){
        System.out.println(valid.get());  //95.0
//        System.out.println(empty.get());  //NoSuchElementException
     }

     static void isPresent(){
         System.out.println(valid.isPresent());  //true
         System.out.println(empty.isPresent());  //false
     }

     static void ofNullable(){
         Double value = null;
         temp = value == null? Optional.<Double>empty():Optional.<Double>of(value);  //Optional.empty

         System.out.println(temp);
         System.out.println(Optional.<Double>ofNullable(valid.get()));  //ofNullable method simplifies the ternary operator expressed above
         System.out.println(Optional.<Double>ofNullable(value));
     }

     static void ifPresent(){
//         ifPresent(Consumer c)
         valid.ifPresent(System.out::println);
         empty.ifPresent(System.out::println);
     }

     static void orElse(){
//         orElse(T other)
         Double d = 1.0;

         System.out.println(valid.orElse(d));
         System.out.println(empty.orElse(d));
     }

     static void orElseGet(){
//         orElseGet(Supplier s)

         Supplier<Double> supplier = ()->new Double(1);

         System.out.println(valid.orElseGet(supplier));
         System.out.println(empty.orElseGet(supplier));
     }

     static void orElseThrow(){
//         orElseThrow(Supplier s)

         Supplier<RuntimeException> supplier = RuntimeException::new;

         System.out.println(valid.orElseThrow(supplier));
         System.out.println(empty.orElseThrow(supplier));
     }

     static void ifPresentOrElse(){
        empty.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));

        empty.ifPresentOrElse( i-> {}, () -> empty = Optional.of(23d));
        empty.ifPresent(System.out::println);
     }

     static void flatMap(){
         Optional<String> o = Optional.ofNullable("a");
         Optional<Optional<String>> wo = Optional.of(o);
         Optional<Optional<Optional<String>>> wwo = Optional.ofNullable(wo);
         Optional<Optional<Optional<Optional<String>>>> wwwwo = Optional.ofNullable(wwo);

         Optional<Optional<String>> oos = wwwwo
                 .flatMap(Optional::get);

         final Optional<Optional<String>> oos2 = oos
                 .flatMap(Optional::of);

     }

    public static void main(String[] args) {
        ifPresentOrElse();
//        m();
//        get();
//        isPresent();
//        ofNullable();
//        ifPresent();
//        orElse();
//        orElseGet();
//        orElseThrow();
    }



}
