package oc.p._8._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._3;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class C implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("c");
        return "c";
    }
}
