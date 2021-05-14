package oc.p._11._7_Concurrency.Review_Questions.qs._4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class R {

    static void m() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadScheduledExecutor();

        var result  = exec.submit(() -> System.out.println("Wake stuff"));
        System.out.println(result.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m();
    }
}
