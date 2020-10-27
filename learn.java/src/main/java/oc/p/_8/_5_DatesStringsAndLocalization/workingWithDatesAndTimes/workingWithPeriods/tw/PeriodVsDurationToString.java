package oc.p._8._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithPeriods.tw;

import utils.print.Print;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class PeriodVsDurationToString {

    static Period p;
    static Duration d;

    static void m(){
        p = Period.ofDays(4);
        System.out.println(p);

        p = Period.ofDays(46);
        System.out.println(p);

        p = Period.ofMonths(1);
        System.out.println(p);

        p = Period.ofYears(1);
        System.out.println(p);

        p = Period.of(1, 1, 1);
        System.out.println(p);
    }

    static void m2(){
        d = Duration.ofNanos(89);
        System.out.println(d);

        d = Duration.ofMillis(99);
        System.out.println(d);

        d = Duration.ofSeconds(99);
        System.out.println(d);

        d = Duration.ofMinutes(99);
        System.out.println(d);

        d = Duration.ofHours(99);
        System.out.println(d);

        d = Duration.ofDays(99);
        System.out.println(d);

        d = Duration.of(99, ChronoUnit.HOURS);
        System.out.println(d);
    }

    public static void main(String[] args) {
        m();
        Print.Delimitators.equal();
        m2();
    }
}
