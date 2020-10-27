package oc.p._11._3.genericsAndCollections.reviewQuestions.qs._19;

import java.util.LinkedList;
import java.util.Queue;

class R {

    static void m(){
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(12);
        System.out.println(q);

        q.remove(1);
        System.out.println(q);

    }

    public static void main(String[] args) {
        m();
    }
}
