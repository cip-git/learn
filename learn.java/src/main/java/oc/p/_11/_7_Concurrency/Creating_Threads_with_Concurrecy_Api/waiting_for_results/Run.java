package oc.p._11._7_Concurrency.Creating_Threads_with_Concurrecy_Api.waiting_for_results;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Run {

    static ExecutorService exec;

    static Callable<String> c = () -> {
        TimeUnit.SECONDS.sleep(2);
        return "C";
    };

    static void m() throws ExecutionException, InterruptedException, TimeoutException {
        try {
            exec = Executors.newCachedThreadPool();

            final Future<String> future = exec.submit(c);
            System.out.println("Submit doesn't block");

            System.out.println(future.isDone()); //false
            System.out.println(future.isCancelled()); //false

            //Retrieves the result of a task, waiting endlessly if it is not yet available
//            System.out.println(future.get());

//            System.out.println(future.get(25, TimeUnit.MILLISECONDS));

            System.out.println(future.cancel(false));
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());


        }finally {
            if(exec != null){
                final List<Runnable> runnables = exec.shutdownNow();
                runnables.forEach(System.out::println);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        m();
    }
}
