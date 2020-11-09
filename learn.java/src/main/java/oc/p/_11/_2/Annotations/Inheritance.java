package oc.p._11._2.Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Repeatable(InheritanceArr.class)
public @interface Inheritance {

    Class base();

    Class[] childs();
}
