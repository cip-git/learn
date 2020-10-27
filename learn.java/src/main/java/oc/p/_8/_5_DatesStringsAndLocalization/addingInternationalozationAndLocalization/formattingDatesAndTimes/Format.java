package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingDatesAndTimes;

import static utils.print.Print.print;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class Format {

    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();
    static LocalDateTime dateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now();
    static Instant instant = zonedDateTime.toInstant();


    static void m() {
        print("DEFAULT");
        print(date);
        print(time);
        print(dateTime);
        print(zonedDateTime);
        print(instant);
    }

    static void iso() {
        print("ISO");
        print(date.format(DateTimeFormatter.ISO_LOCAL_DATE));  //2018-02-02
        print(time.format(DateTimeFormatter.ISO_LOCAL_TIME));  //23:11:43.868
        print(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  //2018-02-02T23:11:43.868
        print(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        print(DateTimeFormatter.ISO_INSTANT.format(instant)); //beware instant doesn't have a format method
    }

    static void shortM() {
        print("SHORT");
        print(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        print(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        print(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }

    static void mediumM() {
        print("MEDIUM");
        print(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        print(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        print(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }


    public static void main(String[] args) {
        m();
        iso();
        shortM();
        mediumM();
    }
}
