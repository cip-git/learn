package oc.p._11._2.Annotations.declaringAnnotation.specificAnnotations.repeatable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The repeatable annotation must be declared with
 * @Repeatable
 * and contain a value that refers to the containing type annotation.
 *
 * The containing type annotation must include an element named
 * value(),
 * which is a primitive array of the repeatable annotation type.
 *
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Risks.class)
@interface Risk {

    String danger();

    int level() default 1;
}

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Risks{
    Risk[] value();
}

class Zoo{

    class Monkey{}

    @Risk(danger = "silly")
    @Risk(danger = "aggressive", level = 5)
    @Risk(danger = "violent", level = 5)
    private Monkey monkeyRepetable;


    @Risks({
            @Risk(danger = "silly"),
            @Risk(danger = "aggregsive", level = 5),
            @Risk(danger = "violent", level = 5)
    })
    private Monkey arrayMonkey;
}