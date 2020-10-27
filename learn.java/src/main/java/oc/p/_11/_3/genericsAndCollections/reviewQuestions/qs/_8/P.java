package oc.p._11._3.genericsAndCollections.reviewQuestions.qs._8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class P {

    String name;
    int beakLength;

    public P(String name, int beakLength) {
        this.name = name;
        this.beakLength = beakLength;
    }

    public String getName() {
        return name;
    }

    public int getBeakLength() {
        return beakLength;
    }

    @Override
    public String toString() {
        return "P{" +
                "name='" + name + '\'' +
                ", beakLength=" + beakLength +
                '}';
    }

    static void m(){
        P p = new P("Paula", 3);
        P p2 = new P("Peter", 5);
        P p3 = new P("Peter", 7);

        final List<P> list = Arrays.asList(p, p2, p3);

//        Collections.sort(list, Comparator.comparing(P::getBeakLength).reversed());

        Collections.sort(
                list,
                Comparator
                        .comparing(P::getName)
                        .thenComparing(Comparator.comparing(P::getBeakLength).reversed()));

//        Collections.sort(
//                list,
//                Comparator
//                        .comparing(P::getName)
//                        .thenComparingInt(P::getBeakLength)
//                        .reversed());

        System.out.println(list);
    }

    public static void main(String[] args) {
        m();
    }
}
