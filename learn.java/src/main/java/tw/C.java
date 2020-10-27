package tw;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class C {

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";
    public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);

    static String date = "2020-02-18T08:00:00.000Z";

    static String date2 = "2030-02-19T09:00:00.000+01:00";

    static void m() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date, PATTERN);
        System.out.println(zonedDateTime.format(PATTERN));
    }

    static void m2(){
         ZonedDateTime zonedDateTime = ZonedDateTime.parse(date2, PATTERN);
       zonedDateTime = zonedDateTime.plus(1, ChronoUnit.MILLIS);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toInstant());
        System.out.println(zonedDateTime.format(PATTERN));
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
