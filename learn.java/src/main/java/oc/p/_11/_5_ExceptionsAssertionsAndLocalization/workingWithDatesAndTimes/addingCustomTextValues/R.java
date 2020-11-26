package oc.p._11._5_ExceptionsAssertionsAndLocalization.workingWithDatesAndTimes.addingCustomTextValues;

import static utils.print.Print.print;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class R {

    static LocalDateTime ldt = LocalDateTime.now();

    static void m(){
        final var formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, 'at' hh:mm");
        print(formatter.format(ldt));

        final var formatter2 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        print(ldt.format(formatter2));

        final var formatter3 =DateTimeFormatter.ofPattern("'New 'yyyy' yay!'");
        print(formatter3.format(ldt));
    }

    public static void main(String[] args) {
        m();
    }
}
