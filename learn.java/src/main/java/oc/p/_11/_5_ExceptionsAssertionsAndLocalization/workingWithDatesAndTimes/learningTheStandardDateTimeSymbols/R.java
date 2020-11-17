package oc.p._11._5_ExceptionsAssertionsAndLocalization.workingWithDatesAndTimes.learningTheStandardDateTimeSymbols;

import static utils.print.Print.print;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import oc.p._11._2.Annotations.Rule;

@Rule("For the exam, " +
        "the rules for defining a custom " +
        "DateTimeFormatter and SimpleDateFormat symbols are the same")

class R {

    static ZonedDateTime zdt = ZonedDateTime.now();

    @FormatRule(
            symbol = "y/Y")
    @FormatRule(
            symbol = "M", max = 5)
    @FormatRule(
            symbol = "d", max = 2)
    @FormatRule(
            symbol = "D", max=3, obs = "day of the year")
    @FormatRule(
            symbol = "h", max = 2)
    @FormatRule(
            symbol = "H", max = 2)
    @FormatRule(
            symbol = "m", max = 2)
    @FormatRule(
            symbol = "s", max = 2)
    @FormatRule(
            symbol = "S", max = 9, obs = "nanoseconds")
    @FormatRule(
            symbol = "a", max = 1)
    @FormatRule(
            symbol = "A", max = 19, obs = "don't know")
    @FormatRule(
            symbol = "z", max = 4, obs = "Eastern European Standard Time:")
    @FormatRule(
            symbol = "Z", max = 5, obs = "ZZZZ -> GMT+02:00, Z/ ZZ/ ZZZ/ ZZZZZ -> +02:00")


    static void m(){
        print(zdt.format(DateTimeFormatter.ofPattern("YYYY-YYYY-DD HH:mm:SSSSSSSSS a zzzz ZZZZ")));
    }

    public static void main(String[] args) {
        m();
    }
}
