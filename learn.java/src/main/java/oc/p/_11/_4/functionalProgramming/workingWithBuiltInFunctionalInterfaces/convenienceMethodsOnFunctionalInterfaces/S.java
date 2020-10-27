package oc.p._11._4.functionalProgramming.workingWithBuiltInFunctionalInterfaces.convenienceMethodsOnFunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class S {

    static Consumer<List<String>> c = l -> l.add("c");
    static Consumer<List<String>> c2 = l -> l.add("c2");
    static Consumer<List<String>> c3 = l -> l.add("c3");

    static void m(){
        var var = new ArrayList<String>();

        c.andThen(c).andThen(c3).accept(var);

        System.out.println(var);
    }

    public static void main(String[] args) {
        m();
    }
}
