package oc.p._8._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithPeriods;

import static utils.print.Print.print;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * static Period	of(int years, int months, int days)
 *
 * static Period	ofDays(int days)
 *
 * static Period	ofMonths(int months)
 *
 * static Period	ofWeeks(int weeks)
 *
 * static Period	ofYears(int years)
 *
 *
 * BEWARE! due to the fact that this are static methods,
 * chaining them results in only having the last chained value
 */
class Periods {

    static Period p;

    static void m(){
        p = Period.ofYears(1);
        print(p);

        p = Period.ofMonths(1);
        print(p);

        p = Period.ofWeeks(5);
        print(p);

        p = Period.ofDays(1);
        print(p);

        p = Period.of(1,1, 1 );
        print(p);

        p = Period.of(-1,-1, -1 );
        print(p);

        p = Period.between(LocalDate.now(), LocalDate.now().plusDays(10));
        print(p);
    }

    static void m2(){

    }

    public static void main(String[] args) {
        m();
    }
}
