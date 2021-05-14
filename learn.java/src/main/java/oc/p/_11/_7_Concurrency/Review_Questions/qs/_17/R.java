package oc.p._11._7_Concurrency.Review_Questions.qs._17;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class R {

    static void addAndPrintItems(BlockingQueue<Integer> queue) throws InterruptedException {
        queue.offer(103);
        queue.offer(20, 1, TimeUnit.SECONDS);
        queue.offer(85, 7, TimeUnit.SECONDS);

        System.out.println(queue.poll(200, TimeUnit.NANOSECONDS));
        System.out.println(queue.poll(1, TimeUnit.MINUTES));
    }

    public static void main(String[] args) throws InterruptedException {
        addAndPrintItems(new ArrayBlockingQueue<Integer>(10));
    }

}
