package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class R {

    static void m(){
        var f = DateTimeFormatter.ofPattern("hh o'clock");
        System.out.println(
//                f.format(ZonedDateTime.now())); IAE
//                f.format(LocalDate.now()));  //IAE
//                f.format(LocalDateTime.now())); //IAE
                f.format(LocalTime.now())); //IAE
    }

    static void m2(){
        var f = DateTimeFormatter.ofPattern("hh 'o''clock'");
        System.out.println(
                f.format(ZonedDateTime.now()));
//                f.format(LocalDate.now()));  //IAE
//                f.format(LocalDateTime.now()));
//                f.format(LocalTime.now()));'
    }

    public static void main(String[] args) {
//        m();

        m2();
    }
}
