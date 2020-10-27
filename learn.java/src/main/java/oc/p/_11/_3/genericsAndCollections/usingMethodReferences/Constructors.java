package oc.p._11._3.genericsAndCollections.usingMethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Constructors {

    Supplier<List<String>> lambda = () -> new ArrayList<>();
    Supplier<List<String>> methodRef = ArrayList::new;
}
