package oc.p._8._5_DatesStringsAndLocalization.workingWithDatesAndTimes.workingWithInstants;

import static utils.print.Print.print;

import java.nio.charset.IllegalCharsetNameException;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * The Instant class represents a specific moment in time in the GMT time zone
 *
 * Instant allows you to add any unit day or smaller
 *
 *
 *  Instant	plus(long amountToAdd, TemporalUnit unit)
 *
 *  Instant	plus(TemporalAmount amountToAdd)
 *
 *  Instant	plusMillis(long millisToAdd)
 *
 *  Instant	plusNanos(long nanosToAdd
 *
 *  Instant	plusSeconds(long secondsToAdd)
 */
class Instants {

    static Instant i = Instant.now();

    static void m(){
//        i = i.plus(Period.ofYears(1)); //RE

        i = i.plus(Period.ofDays(2));
        print(i);

        i = i.plus(Duration.ofDays(2));
        print(i);

        i = i.plus(2, ChronoUnit.DAYS);
        print(i);

        i = i.plusSeconds(60);
        print(i);

        i= i.plusMillis(60);
        print(i);

        i = i.plusNanos(60);
        print(i);
    }

    public static void main(String[] args) {
        m();
    }
}
