package oc.p._8._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithDurations;

import static utils.print.Print.print;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import utils.javaClass.hierrarchy.methods.alphabet.D;

/**
 * static Duration	of(long amount, TemporalUnit unit)
 *
 * static Duration	ofDays(long days)
 *
 * static Duration	ofHours(long hours)
 *
 * static Duration	ofMinutes(long minutes)
 *
 * static Duration	ofSeconds(long seconds)
 *
 * static Duration	ofMillis(long millis)
 *
 * static Duration	ofNanos(long nanos)
 */
class Durations {

    static Duration d;

    static void m(){
        d = Duration.ofDays(4);
        print(d);

        d = Duration.ofHours(23);
        print(d);

        d = Duration.ofMinutes(23);
        print(d);

        d = Duration.ofSeconds(24);
        print(d);

        d = Duration.ofMillis(1);
        print(d);

        d = Duration.ofNanos(1);
        print(d);

        d = Duration.of(4, ChronoUnit.DAYS);
        print(d);

//        d = Duration.of(2, ChronoUnit.WEEKS);  //RE
    }

    static void m2(){
//        d= Duration.from(Period.ofDays(2));  //RE

//        d = Duration.from(Period.ofWeeks(2));  //RE
    }

    static void m3(){
        final LocalDateTime now = LocalDateTime.now();
        d = Duration.between(now, now.minusHours(5));
        print(d);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }



}
