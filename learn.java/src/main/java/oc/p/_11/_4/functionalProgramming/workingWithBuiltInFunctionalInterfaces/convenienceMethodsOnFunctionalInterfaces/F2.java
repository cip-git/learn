package oc.p._11._4.functionalProgramming.workingWithBuiltInFunctionalInterfaces.convenienceMethodsOnFunctionalInterfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

class F2 {

    Function<String, Integer> f = s ->{
        System.out.println("f");
        return s.length();
    };

    Function<Integer, LocalDate> f2 =  i ->{
        System.out.println("f2");
        return LocalDate.now();
    };

    Function<LocalDate, String> f3 = ld ->{
        System.out.println("f3");
        return ld.toString();
    };

    void m(){
        var var = "var";

        final Function<String, String> then = f.andThen(f2).andThen(f3);
        final String r = then.apply(var);
        System.out.println(r);
    }

    void m2(){
        var var = "var";
        final Function<String, String> compose = f3.compose(f2).compose(f);
        final String r = compose.apply(var);
        System.out.println(r);
    }

    public static void main(String[] args) {
        var r = new F2();

        r.m();
        r.m2();
    }
}
