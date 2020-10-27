package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.ex.ex_18;

import java.util.concurrent.TimeUnit;

class C {

    void m() {
        System.out.println("C createAndPopulate() enter");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch(InterruptedException e) {
            System.out.println("caught InterruptedException in C ()");
        }
        System.out.println("C createAndPopulate() end");
    }
}
