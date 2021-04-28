package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.improving_access_with_synchronized_blocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SheepManager {

    final Object herd = new Object();
    private int sheepCount = 0;

    public static void main(String[] args) {
        ExecutorService exec = null;

        try {

            exec = Executors.newFixedThreadPool(20);
            var manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
//                exec.submit(() -> manager.incrementAndReportV1());
                exec.submit(() -> manager.incrementAndReportV2());
            }

        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }
    }

    void incrementAndReportV2() {
        synchronized (herd) {
            System.out.println(++sheepCount + " ");
        }
    }

    void incrementAndReportV1() {
        synchronized (this) {
            System.out.println(++sheepCount + " ");
        }
    }
}
