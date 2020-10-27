package oc.p._11._3.genericsAndCollections.usingDiamondOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * The diamond operator cannot be used as the type in a variable declaration.
 * It can be used only on the right side of an assignment operation.
 */
class DiamondOperator {

    List<Integer> l = new ArrayList<Integer>();
    List<Integer> l2 = new ArrayList<>();

    List<List<Integer>> l3 = new ArrayList<List<Integer>>();
    List<List<Integer>> l4 = new ArrayList<>();


//    List<> l5 = new ArrayList();  //CE

//    var s = "var";  //CE

    {
        var l6 = new ArrayList<Integer>();  //list of integer
        var l7 = new ArrayList<>();  //list of objects

        l6.add(6);
//        l6.add("6");  //CE

        l7.add(7);
        l7.add("7");
    }
}
