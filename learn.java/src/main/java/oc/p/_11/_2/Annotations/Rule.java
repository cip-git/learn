package oc.p._11._2.Annotations;

import java.lang.annotation.Repeatable;

@POC("rule to remember")
@Repeatable(Rules.class)
public @interface Rule {
    String value();

    String[] effect() default {};
}

