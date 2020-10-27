package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p2;

import java.util.Timer;
import java.util.TimerTask;

class Run {

    static void m(){
        R r = new R();
        Thread t = new Thread(r);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                r.increment();
            }
        };
        t.start();
        t2.start();
    }

    public static void main(String[] args) {
        m();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Drop the mike");
                System.exit(1);
            }
        }, 3_000);
    }
}
