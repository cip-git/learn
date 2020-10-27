package oc.p._8._3_GenericsAndCollections.additionInJava8.listOf;

import static utils.print.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.javaClass.hierrarchy.methods.alphabet.C;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.print.Print;

class ListOf {

    static void m(){
        List<String> l = List.of("a", "b", "c" /*, null*/);  //NPE when using null

        print(l);

//        l.add("d");  //RE

//        l.remove(0);  //RE

//        l.set(0, "A"); //RE

        print(l.get(0));
    }


    static void m2(){
        List<String> original = new ArrayList<>();
        original.add("a");
        original.add("b");
        original.add("c");

        List<List<String>> listOf = List.of(original);

        print(original);
        print(listOf);

        original.add("d");
        print(original);
        print(listOf);

        original.remove(0);
        print(original);
        print(listOf);
    }
    static void m3(){
        String[] sa = new String[3];
        sa[0] = "a";
        sa[1] = "b";

//        final List<String> list = List.of(sa);
//        print(Arrays.toString(sa));  //RE
//        print(list);

        sa[2] = "c";
        List<String> list = List.of(sa);
        print(sa);
        print(list);
    }

    static void m4(){
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        final String[] array = l.toArray(new String[0]);

        final List<List<String>> l2 = List.of(l);
        final List<String> l3 = List.of(array);
        final List<String> l4 = List.of(l.toArray(new String[0]));

        l.add("d");

        print(l);
        print(l4);
    }


    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
