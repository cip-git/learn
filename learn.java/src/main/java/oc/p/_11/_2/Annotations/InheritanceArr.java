package oc.p._11._2.Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.CLASS)
public @interface InheritanceArr {

    Inheritance[] value();
}
