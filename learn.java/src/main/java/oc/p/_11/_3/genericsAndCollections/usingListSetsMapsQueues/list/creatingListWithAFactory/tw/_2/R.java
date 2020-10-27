package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.list.creatingListWithAFactory.tw._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.javaClass.implemets.serializable.simple.Tea;
import utils.javaClass.implemets.serializable.simple.TeaPot;
import utils.print.Print;

class R {

    List<TeaPot> lst = new ArrayList<>();

    {
        List
                .of(Tea.values())
                .stream()
                .map(TeaPot::new)
                .forEach(lst::add);
    }

    void m(List<TeaPot> res) {
        print(res);

        res.forEach(t -> t.setTea(Tea.GREEN));
        print(res);

        lst.forEach(t -> t.setTea(Tea.BLACK));
        print(res);

        lst.replaceAll(t -> new TeaPot(Tea.GREEN));
        print(res);

        res.forEach(t -> t.setTea(Tea.FRUIT));
        print(res);

        lst.clear();
        print(res);
    }

    private void print(List<TeaPot> res) {
        System.out.println(lst);
        System.out.println(res);
        Print.Delimitators.newLine();
    }


    public static void main(String[] args) {
        final R r = new R();

//        r.m(List.of(r.lst.toArray(new TeaPot[0])));
//        r.m(List.copyOf(r.lst));
        r.m(Arrays.asList(r.lst.toArray(new TeaPot[0])));
    }
}
