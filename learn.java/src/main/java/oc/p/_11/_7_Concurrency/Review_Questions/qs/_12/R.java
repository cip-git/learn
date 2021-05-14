package oc.p._11._7_Concurrency.Review_Questions.qs._12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class R {

    void takeNap() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    void m() throws InterruptedException {
        ExecutorService exec = null;

        final long start = System.currentTimeMillis();
        try{

            exec = Executors.newFixedThreadPool(4);

            exec.execute(() -> takeNap());
            exec.execute(() -> takeNap());
            exec.execute(() -> takeNap());

        }finally {
            if(exec != null){
                exec.shutdown();
            }
        }

        exec.awaitTermination(2 , TimeUnit.SECONDS);
        System.out.println("Done: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) throws InterruptedException {
        new R().m();
    }
}
