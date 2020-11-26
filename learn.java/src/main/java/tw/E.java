package tw;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

class E {

    static void m(){
        final ZonedDateTime timestamp = ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT,  ZoneId.of(ZoneOffset.UTC.getId()));
        System.out.println(timestamp);
    }

    public static void main(String[] args) {
        m();
    }
}
