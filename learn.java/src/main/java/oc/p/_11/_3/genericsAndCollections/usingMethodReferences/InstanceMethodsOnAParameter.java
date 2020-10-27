package oc.p._11._3.genericsAndCollections.usingMethodReferences;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

class InstanceMethodsOnAParameter {

    Predicate<String> lambada = s -> s.isEmpty();
    Predicate<String> methodRef = String::isEmpty;


    BiPredicate<String, String> lambda2 = (s, s2) -> s.startsWith(s2);
    BiPredicate<String, String> methodRef2 = String::startsWith;

}
