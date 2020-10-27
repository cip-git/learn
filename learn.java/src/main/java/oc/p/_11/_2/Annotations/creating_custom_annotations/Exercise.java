package oc.p._11._2.Annotations.creating_custom_annotations;


@interface Exercise {
    int hoursPerDay();
    int startHour() default 6;
}

@Exercise(hoursPerDay = 1, startHour = 7)
class Chhetah{}

@Exercise(hoursPerDay = 2)
class Sloth{}

@Exercise(startHour = 8, hoursPerDay = 2)
class ZooEmployee{}