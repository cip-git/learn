package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class R {

    static void m(){
        LocalDate date =
                LocalDate.parse(
                        "2020-04-30",
//                        DateTimeFormatter.ISO_LOCAL_DATE_TIME //RE
                        DateTimeFormatter.ISO_LOCAL_DATE

                );

        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
    }

    public static void main(String[] args) {
        m();
    }
}
