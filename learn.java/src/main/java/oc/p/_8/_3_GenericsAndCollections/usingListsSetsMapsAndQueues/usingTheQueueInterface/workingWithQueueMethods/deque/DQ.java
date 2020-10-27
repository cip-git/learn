package oc.p._8._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods.deque;

import static utils.print.Print.print;

import java.util.ArrayDeque;
import java.util.Deque;

class DQ {

    static Deque<String> deque = new ArrayDeque<>();

    static void m(){
        print("INSERT");
        //special value
        deque.offer("b");
        deque.offerFirst("a");
        deque.offerLast("c");
        print(deque);
        //may throw RE
        deque.add("d");
        deque.addFirst("Z");
        deque.addLast("e");
        print(deque);
        deque.add("f");
        deque.add("g");
        deque.add("h");
        deque.add("i");
        deque.add("j");

        print("REMOVE");
        //special value
        print(deque);
        print(deque.poll());  //Z
        print(deque.removeFirst());  //a
        print(deque.removeLast());  //j

        //may throw RE
        print(deque.remove());  //b
        print(deque.removeFirst());  //c
        print(deque.removeLast());    //i
        print(deque);

        print("EXAMINE");
        //special value
        print(deque.peek());  //d
        print(deque.peekFirst());  //d
        print(deque.peekLast());  //h

        //may throw RE
        print(deque.element());  //d
        print(deque.getFirst());  //d
        print(deque.getLast());  //h
    }


    public static void main(String[] args) {
        m();
    }
}
