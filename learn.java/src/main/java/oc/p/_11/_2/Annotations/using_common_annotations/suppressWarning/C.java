package oc.p._11._2.Annotations.using_common_annotations.suppressWarning;

import java.util.ArrayList;
import java.util.List;

import oc.p._11._2.Annotations.Rule;

class C {

    /**
     * A good practice would is to provide this Javadoc and specify what to use instead
     *
     * @deprecated,
     */
    @Deprecated
    void m(){

    }

    @Rule("deprecation/unchecked for the exam" )
    @SuppressWarnings("aici e nevoie de un text")
    void m2(){
        m();
    }

    @SuppressWarnings("unchecked")
    void m3(){
        List l = new ArrayList();
        System.out.println(l);
    }
}
