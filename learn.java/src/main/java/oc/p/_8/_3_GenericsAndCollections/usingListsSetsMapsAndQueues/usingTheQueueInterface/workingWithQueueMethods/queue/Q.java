package oc.p._8._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods.queue;

import static utils.print.Print.print;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

import utils.print.Print;

class Q {

    static Queue<String> queue = new ArrayDeque<>(2);

    static void m(){
        final boolean offer = queue.offer("a");
        final String poll = queue.poll();
        final String peek = queue.peek();

        print(offer, poll, peek);
    }

    static void m2(){
        final boolean add = queue.add("a");  //might throw RE
        print(queue);
        final boolean add2 = queue.add("b");
        print(queue);
        final String remove = queue.remove();  //throws RE if no elements
        print(queue);
        final String element = queue.element();//RE if no elements
        print(add, add2, remove, element, queue);
    }

    static void m3(){
//        Deque<String> deque = new ArrayDeque<>();
        Deque<String> deque = new LinkedList<>();

        deque.offer("a");
        print(deque);

        deque.offer("b");
        print(deque);

        deque.add("c");
        print(deque);

        deque.add("d");
        print(deque);

        print(deque.remove());  //a
        print(deque);

        print(deque.poll());  //b
        print(deque);

        print(deque.element());  //c
        print(deque);

        print(deque.peek());  //c
        print(deque);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
