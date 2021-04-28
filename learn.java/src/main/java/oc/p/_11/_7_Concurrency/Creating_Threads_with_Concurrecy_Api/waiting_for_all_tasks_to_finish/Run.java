package oc.p._11._7_Concurrency.Creating_Threads_with_Concurrecy_Api.waiting_for_all_tasks_to_finish;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class Run {

    static ExecutorService exec;

    static Callable<Long> c = () ->{
        TimeUnit.SECONDS.sleep(1);
        final long id = Thread.currentThread().getId();
        return id;
    };


    static void m() throws InterruptedException {
        try{

            exec = Executors.newCachedThreadPool();

            LongStream
                    .rangeClosed(1, 5)
                    .mapToObj(l -> c)
                    .collect(Collectors.toList())
                    .forEach(exec::submit);

        }finally {
            if(exec != null){
                exec.shutdown();
            }
        }

        if(exec !=null){
            exec.awaitTermination(25, TimeUnit.MILLISECONDS);
//            exec.awaitTermination(2, TimeUnit.SECONDS);

            if(exec.isTerminated()){
                System.out.println("All task terminated");
            }else {
                System.out.println("At least one thread is still running");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
