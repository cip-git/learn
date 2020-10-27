package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.list.creatingListWithAFactory;

import java.util.Arrays;
import java.util.List;

class R {

    static String[] base = new String[]{"a", "b", "c"/*, null*/};

    public static void main(String[] args) {
//        asList();
//        of();
//        copyOf();
    }

    static void of() {
        /**
         * Returns immutable list
         *
         * Doesn't accept null elems -> RE
         */
        final List<String> list = List.of(base);
//        list.add("d");  //RE
//        list.remove("a");  //RE
//        list.set(0, list.get(0).toUpperCase());  //RE
    }

    static void copyOf() {
        /**
         * Return immutable list with copy of original collection's values
         *
         * Doesn't accept null elems -> RE
         */
        final List<String> list = List.copyOf(Arrays.asList(base));

//        list.add("d");  //RE
//        list.remove("a");  //RE
//        list.set(0, list.get(0).toUpperCase());  //RE
    }

    static void asList() {
        /**
         * Returns fixed size list backed by an array
         */
        final List<String> list = Arrays.asList(base);
//        list.add("d");  //RE
//        list.remove("a");  //RE
        list.set(0, list.get(0).toUpperCase());

        System.out.println(list);
        System.out.println(Arrays.toString(base));
    }
}
