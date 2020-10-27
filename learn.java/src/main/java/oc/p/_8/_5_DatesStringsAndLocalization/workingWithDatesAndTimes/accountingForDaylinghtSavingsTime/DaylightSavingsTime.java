package oc.p._8._5_DatesStringsAndLocalization.workingWithDatesAndTimes.accountingForDaylinghtSavingsTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

class DaylightSavingsTime {

    static void spring(){
        ZonedDateTime zdt = springZdt();
        ZonedDateTime zdt2 = zdt.plus(1, ChronoUnit.HOURS);
        ZonedDateTime zdt3 = zdt.minus(Duration.ofHours(1));

        System.out.println(zdt);
        System.out.println(zdt2);
        System.out.println(zdt3);
        System.out.println(zdt.toInstant());
        System.out.println(zdt2.toInstant());
        System.out.println(zdt3.toInstant());
    }


    static void fall(){
        ZonedDateTime zdt = fallZdt();
        ZonedDateTime zdt2 = zdt.plus(Duration.of(1, ChronoUnit.HOURS));
        ZonedDateTime zdt3 = zdt.minus(1, ChronoUnit.HOURS);
        ZonedDateTime zdt4 = zdt2.minus(1, ChronoUnit.HOURS);

        System.out.println(zdt);
        System.out.println(zdt2);
        System.out.println(zdt3);
        System.out.println(zdt4);

        System.out.println(zdt.toInstant());
        System.out.println(zdt2.toInstant());
        System.out.println(zdt3.toInstant());
        System.out.println(zdt4.toInstant());
    }

    private static ZonedDateTime springZdt() {
        LocalDate localDate = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        return ZonedDateTime.of(localDate, localTime, zoneId);
    }

    private static ZonedDateTime fallZdt() {
        LocalDate localDate = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime, zoneId);
        return zdt;
    }

    public static void main(String[] args) {
//        spring();
        fall();
    }


}
