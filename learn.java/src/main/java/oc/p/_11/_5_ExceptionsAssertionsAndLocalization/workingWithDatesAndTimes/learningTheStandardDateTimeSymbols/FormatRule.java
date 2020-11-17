package oc.p._11._5_ExceptionsAssertionsAndLocalization.workingWithDatesAndTimes.learningTheStandardDateTimeSymbols;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(FormatRules.class)
@interface FormatRule {

    String symbol();

    int min() default 0;

    int max() default Short.MAX_VALUE;

    String obs() default "";
}
