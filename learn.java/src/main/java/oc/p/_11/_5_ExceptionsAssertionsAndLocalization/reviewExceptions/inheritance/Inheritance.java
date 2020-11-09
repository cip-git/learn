package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewExceptions.inheritance;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;

@Documented
@Repeatable(InheritanceArr.class)
@interface Inheritance {

    Class base() ;

    Class[] childs();
}
