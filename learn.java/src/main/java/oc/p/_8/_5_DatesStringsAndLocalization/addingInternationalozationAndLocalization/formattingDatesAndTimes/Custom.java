package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingDatesAndTimes;

import static utils.print.Print.print;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * yyyy
 * y represents the year.
 * yy outputs a two-digit year and
 * yyyy outputs a four-digit year.
 * YYYY - seems to be a difference for parsing: don't know yet, but for parsing use y instead of Y
 *
 * MMMM
 * M represents the month.
 * M outputs 1,
 * MM outputs 01,
 * MMM outputs Jan,
 * MMMM outputs January.
 *
 * dd
 * d represents the day in the month.
 * dd means to include the leading zero for a single-digit day.
 * DD represents day of year
 *
 * hh
 * h represents the hour.
 * hh to include the leading zero if you’re outputting a single-digit hour.
 * HH 24 hour format
 *
 * mm
 * date represents the minute omitting the leading zero if present.
 * mm is more common and represents the minutes using two digits.
 *
 * ss
 * seconds
 *
 * SS nanoseconds (displays 2)
 *
 * a
 * AM/PM
 *
 * n  for nanoseconds
 *
 * ns/ nss
 * A/N nono of day
 *
 * , if you want to output a comma (this also appears after the year).
 * : if you want to output a colon
 */
class Custom {

    static void m(){
        ZonedDateTime zdt = ZonedDateTime.now();

        print(zdt.format(DateTimeFormatter.ofPattern("y-M-d, YYYY-MMMM-dd, DD, hh-mm-ss a, A N, HH-mm-ss.SSSSSSSSS, Z, ZZZZ, z, zzzz,")));
    }

    public static void main(String[] args) {
        m();
    }
}
