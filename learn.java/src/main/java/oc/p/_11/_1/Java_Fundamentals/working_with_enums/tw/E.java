package oc.p._11._1.Java_Fundamentals.working_with_enums.tw;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

enum E {

    A;

    public String publicString;
    private String privateString;
    protected String protectedString;
    String defaultString;
    static final String staticString = "staticString";
}


class Run{

    static void m(){
        ZoneOffset
                .getAvailableZoneIds()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        System.out.println(E.A.protectedString);
//
//        System.out.println(E.staticString);
//
//
//        System.out.println(LocalDateTime.now());
        m();
    }
}