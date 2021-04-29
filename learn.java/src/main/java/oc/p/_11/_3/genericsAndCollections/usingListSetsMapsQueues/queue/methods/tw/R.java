package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.queue.methods.tw;

import java.util.ArrayDeque;
import java.util.Queue;

class R {

    static Queue<Integer> queue = new ArrayDeque<>();

    static {
        queue.add(7);
    }

    static void specialValue(){
        final boolean offer = queue.offer(5);
        final Integer peek = queue.peek();
        final Integer poll = queue.poll();

        System.out.println(offer);
        System.out.println(peek);
        System.out.println(poll);
    }

    static void re(){
        final boolean add = queue.add(5);
        final Integer element = queue.element();
        final Integer remove = queue.remove();

        System.out.println(add);
        System.out.println(element);
        System.out.println(remove);
    }

    public static void main(String[] args) {
//        specialValue();

        re();
    }
}
