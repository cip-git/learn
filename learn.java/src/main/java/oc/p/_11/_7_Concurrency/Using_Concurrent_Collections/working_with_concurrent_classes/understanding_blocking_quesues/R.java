package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_blocking_quesues;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class R {

    static void m(){
        try {
            var bq = new LinkedBlockingQueue<Integer>();

            final boolean offer = bq.offer(39);
            System.out.println(offer);

            final boolean offer1 = bq.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(offer1);

            final Integer poll = bq.poll();
            System.out.println(poll);

            final Integer poll1 = bq.poll(4, TimeUnit.SECONDS);
            System.out.println(poll1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }

}
