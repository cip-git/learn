package oc.p._11._3.genericsAndCollections.usingMethodReferences;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class StaticMethods {

    Consumer<List<String>> lambda = l -> Collections.sort(l);
    Consumer<List<String>> metRef = Collections::sort;

}
