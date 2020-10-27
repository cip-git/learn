package oc.p._11._3.genericsAndCollections.sortingData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.javaClass.implemets.serializable.simple.Tea;
import utils.javaClass.implemets.serializable.simple.TeaPot;

class R2 {

    TeaPot t = new TeaPot(Tea.GREEN);
    TeaPot t2 = new TeaPot(Tea.BLACK);

    List<TeaPot> lst;
    TeaPot[] arr;

    {
        lst = new ArrayList<>();
        lst.add(t);
        lst.add(t2);

        arr = new TeaPot[2];
        arr[0] = t;
        arr[1] = t2;
    }

    void m(){
//        Collections.sort(lst);  //CE, TeaPot isn't Comparable
        Collections.sort(lst, Comparator.comparing(TeaPot::getLocalDateTime));

//        Arrays.sort(arr);  //RE because it knows the type only at runtime
        Arrays.sort(arr, Comparator.comparing(TeaPot::getLocalDateTime));
    }

    public static void main(String[] args) {
        var var = new R2();

        var.m();
    }
}
