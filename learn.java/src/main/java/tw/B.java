package tw;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class B {

    public static final String PAGE_TOKEN_PATTERN = //
            "^[12]\\d{3}(-[01]\\d(-[0-3]\\d(T[0-2]\\d:[0-5]\\d(:[0-5]\\d)?((.*)?(" // ZonedDateTime
                    + "_" //
                    + "[0-9A-Fa-f]{32}" // uuid
                    + ")?)?)?)?)?$";
                                        //   2020     - 0   1  -  3    1 T  1    9: 5     7:  5     7
    public static final String PATTERN = "^[12]\\d{3}(\\-[01]\\d(-[0-3])\\d(T[0-2]\\d:[0-5]\\d(:[0-5]\\d))\\.\\d{3}(((\\+([0-5]\\d:[0-5]\\d))|Z)))$";


    static String   DATE = "2020-01-31T16:58:46.029Z";
    static String DATE_2 = "2020-01-31T16:58:46.029+02:00";


    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";

    static void m(){
        final Pattern pattern = Pattern.compile(PATTERN);

        System.out.println(DATE.matches(PAGE_TOKEN_PATTERN));
        System.out.println(DATE_2.matches(PAGE_TOKEN_PATTERN));


        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
        final ZonedDateTime zdt = ZonedDateTime.parse(DATE, formatter);

        final ZonedDateTime zdt2 = ZonedDateTime.parse(DATE_2, formatter);

        System.out.println(zdt);
        System.out.println(zdt2);

        final String zdt3 = ZonedDateTime.now().format(formatter);
        System.out.println(zdt3);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        m();
    }
}
