package oc.p._11._2.Annotations;

import java.lang.annotation.Repeatable;

@Repeatable(GoodPractices.class)
public @interface GoodPractice {
    String value();

    String[] effect() default {};
}
