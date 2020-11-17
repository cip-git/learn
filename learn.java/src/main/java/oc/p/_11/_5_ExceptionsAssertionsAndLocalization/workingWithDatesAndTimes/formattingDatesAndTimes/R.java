package oc.p._11._5_ExceptionsAssertionsAndLocalization.workingWithDatesAndTimes.formattingDatesAndTimes;

import static utils.print.Print.print;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import utils.print.Print;

class R {

    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();
    static LocalDateTime dateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now();

    static void m(){
        System.out.println(date);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        Print.Delimitators.newLine();

        System.out.println(time);
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        Print.Delimitators.newLine();

        System.out.println(dateTime);
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        Print.Delimitators.newLine();

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

    public static void main(String[] args) {
        m();
    }
}
