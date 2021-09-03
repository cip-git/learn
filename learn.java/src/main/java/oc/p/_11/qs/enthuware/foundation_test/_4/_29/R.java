package oc.p._11.qs.enthuware.foundation_test._4._29;

import java.util.Arrays;
import java.util.List;

class R {

    static void m(){
        List<Double> dList = Arrays.asList(10.0, 12.0);

        dList.forEach(x->{ x = x + 10; });
        dList.forEach(x->System.out.println(x));
    }

    public static void main(String[] args) {
        m();
    }
}
