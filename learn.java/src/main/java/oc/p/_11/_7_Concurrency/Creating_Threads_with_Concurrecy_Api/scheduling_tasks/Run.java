package oc.p._11._7_Concurrency.Creating_Threads_with_Concurrecy_Api.scheduling_tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


class Run {

    static final Runnable R = () -> System.out.println("R");

    static final Callable<String> C = () -> {
        System.out.println("C");
        return "C";
    };

    static ScheduledExecutorService exec;


    static void m() throws InterruptedException {
        try {

            exec = Executors.newSingleThreadScheduledExecutor();

            final ScheduledFuture<?> r = exec.schedule(R, 1, TimeUnit.SECONDS);

            System.out.println(r.isDone()); //false
            System.out.println(r.isCancelled()); //false

            System.out.println(r.getDelay(TimeUnit.MILLISECONDS));

        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }

        afterShutDownCheck();
    }

    static void m2() throws InterruptedException {
        try {

            exec = Executors.newSingleThreadScheduledExecutor();

            final ScheduledFuture<String> r = exec.schedule(C, 1, TimeUnit.SECONDS);

            System.out.println(r.isDone()); //false
            System.out.println(r.isCancelled()); //false

            System.out.println(r.getDelay(TimeUnit.MILLISECONDS));

        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }

        afterShutDownCheck();
    }

    static void m3() throws InterruptedException {
        try {

            exec = Executors.newSingleThreadScheduledExecutor();

            final ScheduledFuture<?> scheduledFuture = exec.scheduleAtFixedRate(R, 0, 25, TimeUnit.MILLISECONDS);

            System.out.println(scheduledFuture.isDone());  //false
            System.out.println(scheduledFuture.isCancelled());  //false

            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));

            TimeUnit.MILLISECONDS.sleep(75);

        } finally {
            if (exec != null) {
                exec.shutdown();
            }
        }

        afterShutDownCheck();
    }

    private static void afterShutDownCheck() throws InterruptedException {
        if (exec != null) {
            System.out.println("exec.isShutdown(): " + exec.isShutdown());
            System.out.println("exec.isTerminated(): " + exec.isTerminated());
            exec.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("exec.isShutdown(): " + exec.isShutdown());
            System.out.println("exec.isTerminated(): " + exec.isTerminated());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        m();
//        m2();

        m3();
    }
}
