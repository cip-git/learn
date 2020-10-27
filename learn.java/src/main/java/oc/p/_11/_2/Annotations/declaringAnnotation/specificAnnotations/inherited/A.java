package oc.p._11._2.Annotations.declaringAnnotation.specificAnnotations.inherited;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@java.lang.annotation.Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface A {
    String value();
}

@java.lang.annotation.Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface B{
    String value();
}

@A("a")
@B("b")
class C{

}

class C2 extends C{

    static void c(){
        final Annotation[] declaredAnnotations = C.class.getAnnotations();
        for(Annotation a: declaredAnnotations){
            System.out.println(a);
        }
    }


    static void c2(){
        final Annotation[] annotations = C2.class.getAnnotations();
        for(Annotation a:  annotations){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        c();
//        c2();
    }
}
