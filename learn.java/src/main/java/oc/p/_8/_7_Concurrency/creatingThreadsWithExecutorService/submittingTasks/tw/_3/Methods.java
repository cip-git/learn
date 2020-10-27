package oc.p._8._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._3;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * ScheduledExecutorService -> executorService
 */
class Methods {

    ScheduledExecutorService scheduledExecutor =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Methods m = new Methods();

        /**
         * For both executorService and ScheduledExecutorService
         */
//        m.execute();
//        m.submitRunnable();
//        m.submitCallable();

        //SYNCHRONOUSLY METHODS: so blocking methods
//        m.invokeAll();
//        m.invokeAny();

        /**
         * Only for ScheduledExecutorService
         */
//        m.scheduleRunnable();
//        m.scheduleCallable();
//        m.scheduleAtFixRate();
        m.scheduleWithFixDelay();

        m.clean();
    }

    void scheduleWithFixDelay() throws InterruptedException {
        final ScheduledFuture <?> sf = scheduledExecutor.scheduleWithFixedDelay(new R(), 0, 1000, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(2);
    }

    void scheduleAtFixRate() throws InterruptedException, ExecutionException {
        final ScheduledFuture <?> scheduledFuture =
                scheduledExecutor.scheduleAtFixedRate(new R(), 0, 500, TimeUnit.MILLISECONDS);
//        System.out.println("res: " + scheduledFuture.get());  //makes the code run forever
        TimeUnit.SECONDS.sleep(2);
    }

    void scheduleCallable() throws ExecutionException, InterruptedException {
        ScheduledFuture <String> sf = scheduledExecutor.schedule(new C(), 500, TimeUnit.MILLISECONDS);
        String s = sf.get();
        System.out.println(s);
    }

    void scheduleRunnable() throws ExecutionException, InterruptedException {
        final ScheduledFuture <?> schedule = scheduledExecutor.schedule(new R(), 500, TimeUnit.MILLISECONDS);
        final Object x = schedule.get();
        System.out.println(x);
    }

    void invokeAny() throws ExecutionException, InterruptedException {
        final Collection <Callable <String>> list = IntStream.range(1, 10).mapToObj(i -> new C()).collect(toList());
        String s = scheduledExecutor.invokeAny(list);
        System.out.println("res: " + s);
    }

    void invokeAll() throws InterruptedException {
        final Collection <Callable <String>> list = IntStream.range(1, 10).mapToObj(i -> new C()).collect(toList());
        List <Future <String>> collection = scheduledExecutor.invokeAll(list);
        collection.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public void clean() {
        scheduledExecutor.shutdown();
        try {
            scheduledExecutor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void submitCallable() throws ExecutionException, InterruptedException {
        final Future <String> submit = scheduledExecutor.submit(new C());
        System.out.println(submit.get());
    }

    void execute() {
        scheduledExecutor.execute(new R());
    }

    void submitRunnable() throws ExecutionException, InterruptedException {
        Future <?> f = scheduledExecutor.submit(new R());
        System.out.println(f.get());
    }

}
