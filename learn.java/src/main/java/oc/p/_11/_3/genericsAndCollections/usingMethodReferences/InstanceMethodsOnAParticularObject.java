package oc.p._11._3.genericsAndCollections.usingMethodReferences;

import java.util.function.Predicate;

class InstanceMethodsOnAParticularObject {

    String str = "abc";

    Predicate<String> lambda = s -> str.startsWith(s);
    Predicate<String> methodRef = str::startsWith;

}
