package oc.p._8._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._3;

import java.util.concurrent.TimeUnit;

class R implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("r");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
