package oc.p._11._2.Annotations.rmb;

import java.util.ArrayList;
import java.util.List;

/**
 * Any time you invoke a method or declare a method
 * that uses varargs with a generic type, you will get an "unchecked" warning.
 *
 */
class Unchecked {


//    @SafeVarargs  // NO need to add the annotation to the main method
    @SuppressWarnings("unchecked")  // Need to add the annotation to the main method
    static void m(List<String>... ls){
        ls[0] = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        m(new ArrayList<>());
    }
}
