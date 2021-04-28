package oc.p._11._7_Concurrency.Creating_Threads_with_Concurrecy_Api.submitting_tasks;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Run {

    static ExecutorService exec;

    static void m() throws ExecutionException, InterruptedException {
        try {
            exec = Executors.newCachedThreadPool();

            final Future<?> runnable = exec.submit(() -> System.out.println("Runnable"));

            System.out.println(runnable.isDone());
            System.out.println(runnable.isCancelled());
            System.out.println(runnable.get());

        } finally {
            if (exec != null) {
                final List<Runnable> runnables = exec.shutdownNow();
            }
        }
    }

    static void m2() throws InterruptedException {
        try {

            exec = Executors.newSingleThreadExecutor();
//            exec = Executors.newCachedThreadPool();

            final List<C> list = IntStream
                    .rangeClosed(1, 5)
                    .mapToObj(i -> new C())
                    .collect(toList());

            final long start = System.currentTimeMillis();
            final List<Future<String>> futures = exec.invokeAll(list);
            final long end = System.currentTimeMillis();

            System.out.println(end - start);

            futures
                    .stream()
                    .map(Future::isDone)
                    .forEach(System.out::println);

        } finally {
            if (exec != null) {
                final List<Runnable> runnables = exec.shutdownNow();
                runnables.forEach(System.out::println);
            }
        }
    }

    static void m3() throws InterruptedException, ExecutionException {
        try {

//            exec = Executors.newSingleThreadExecutor();
            exec = Executors.newCachedThreadPool();

            final List<C> list = IntStream
                    .rangeClosed(1, 5)
                    .mapToObj(i -> new C())
                    .collect(toList());

            final long start = System.currentTimeMillis();
            final String invokeAny = exec.invokeAny(list);
            final long end = System.currentTimeMillis();

            System.out.println(end - start);

            System.out.println(invokeAny);

        } finally {
            if (exec != null) {
                final List<Runnable> runnables = exec.shutdownNow();
                runnables.forEach(System.out::println);
            }
        }
    }

    static class C implements Callable<String> {
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            final long id = Thread.currentThread().getId();
            return String.valueOf(id);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        m();
//        m2();
        m3();
    }
}

