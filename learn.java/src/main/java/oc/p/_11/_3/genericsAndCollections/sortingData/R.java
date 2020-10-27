package oc.p._11._3.genericsAndCollections.sortingData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class R {

    List<Integer> lst;
    Integer[] arr;
    int[] arr2;

    {
        lst = new ArrayList<>();
        lst.add(2);
        lst.add(3);
        lst.add(1);

        arr = new Integer[3];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 1;

        arr2 = new int[3];
        arr2[0] = 2;
        arr2[1] = 3;
        arr2[2] = 1;
    }

    void m(){
        Collections.sort(lst);
        Collections.sort(lst, Comparator.reverseOrder());

        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.reverseOrder());

        Arrays.sort(arr2);
//        Arrays.sort((int[])arr2, Comparator.comparingInt(i -> (int)i));  //CE
    }



}
