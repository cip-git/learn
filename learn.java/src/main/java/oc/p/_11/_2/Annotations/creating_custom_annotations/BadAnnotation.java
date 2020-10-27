package oc.p._11._2.Annotations.creating_custom_annotations;

@interface BadAnnotation {
//    String name(); default new String();  //CE

    String address() default "";

//    String title() default null;  //CE
}
