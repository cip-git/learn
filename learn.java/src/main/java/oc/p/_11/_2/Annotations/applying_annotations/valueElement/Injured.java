package oc.p._11._2.Annotations.applying_annotations.valueElement;

/**
 * The annotation declaration must contain an element named value(),
 * which may be optional or required.
 *
 * The annotation declaration must not contain any other elements that are required.
 *
 * The annotation usage must not provide values for any other elements.
 */

@interface Injured {

    String vegetarian() default "unassigned";
    String value() default "foot";
    int age() default 1;
}

@Injured("broken leg")
class Monkey{}

@Injured(value = "injured", age = 2)
class Monkey2{

}

abstract class Elephant{
    @Injured("legs") void fallDown(){}
    @Injured(value = "legs") abstract void trip();
    @Injured String injuries[];
}


