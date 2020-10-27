package oc.p._8._7_Concurrency.creatingThreadsWithExecutorService.submittingTasks.tw._3;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class SynchronVsAsynchron {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SynchronVsAsynchron sva = new SynchronVsAsynchron();
//        sva.m();
        sva.m2();
    }

    void m() throws InterruptedException, ExecutionException {

        scheduledExecutorService.execute(new R());
        System.out.println("execute(runnable) is asynchronous");

        scheduledExecutorService.submit(new R());
        System.out.println("submit(runnable) is asynchronous");

        scheduledExecutorService.submit(new C());
        System.out.println("submit(callable) is asynchronous");

        List <Future <String>> lf = scheduledExecutorService.invokeAll(lst());
        System.out.println("invokeAll(Collection<? extends Callable<T>) is synchronous");

        String s = scheduledExecutorService.invokeAny(lst());
        System.out.println("invokeAny(Collection<? extends Callable<T>> is synchronous)");

        clean();
    }

    void m2() throws InterruptedException {
        scheduledExecutorService.schedule(new R(), 500, TimeUnit.MILLISECONDS);
        System.out.println("schedule(runnable) is asynchronous");

        scheduledExecutorService.schedule(new C(), 500, TimeUnit.MILLISECONDS);
        System.out.println("schedule(callable) is asynchronous");

        scheduledExecutorService.scheduleAtFixedRate(new R(), 500, 500, TimeUnit.MILLISECONDS);
        System.out.println("scheduleAtFizedRate(runnable, initialDelay, period, TimeUnit) is asynchronous");

        scheduledExecutorService.scheduleWithFixedDelay(new R(), 500, 500, TimeUnit.MILLISECONDS);
        System.out.println("scheduleWithFixedDelay(runnable, initialDelay, period, TimeUnit) is asynchronous");

        clean();
    }

    private void clean() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        scheduledExecutorService.shutdown();
        scheduledExecutorService.awaitTermination(3, TimeUnit.SECONDS);
    }

    Collection <C> lst() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new C())
                .collect(toList());
    }
}
