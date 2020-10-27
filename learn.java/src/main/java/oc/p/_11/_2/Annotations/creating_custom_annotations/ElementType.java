package oc.p._11._2.Annotations.creating_custom_annotations;

@interface ElementType {

    int primitives() default 1;

//    Integer wrapperClasses() default Integer.valueOf(1);  //CE: attribute must be a constant

    String string() default "";

    Class clazz() default String.class;

    Seasons enums() default Seasons.SS;

    Exercise annotation() default @Exercise(hoursPerDay = 1, startHour = 7);

    int[] primitivesArray() default {};

    String[] stringArray() default {};

    Class[] classArr() default {};

    Seasons[] enumArr() default {};

    Exercise[] annotationArr()
            default {@Exercise(startHour = 7, hoursPerDay = 1), @Exercise(startHour = 8, hoursPerDay = 1)};
 }

enum Seasons{
    S,SS, A, W
}


