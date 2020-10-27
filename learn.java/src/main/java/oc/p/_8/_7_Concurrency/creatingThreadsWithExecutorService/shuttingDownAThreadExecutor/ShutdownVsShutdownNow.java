package oc.p._8._7_Concurrency.creatingThreadsWithExecutorService.shuttingDownAThreadExecutor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class ShutdownVsShutdownNow {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    Consumer <ExecutorService> SHUTDOWN = ExecutorService::shutdown;

    Consumer <ExecutorService> SHUTDOWN_NOW = exec -> {
        List <Runnable> runnables = exec.shutdownNow();
        runnables.forEach(System.out::println);
    };

    public static void main(String[] args) {
        new ShutdownVsShutdownNow().runM();
    }

    void m(Consumer <ExecutorService> consumer) {
        ExecutorService exec = null;
        try {
            exec = Executors.newFixedThreadPool(4);
            final List <Callable <Integer>> list = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new C())
                    .collect(toList());
            for (Callable <Integer> c : list) {
                exec.submit(c);
            }
        } finally {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (exec != null) {
                consumer.accept(exec);
                System.out.println(exec.isShutdown());
                System.out.println(exec.isTerminated());
            }
        }
    }

    void runM() {
//        m(SHUTDOWN);
        m(SHUTDOWN_NOW);
    }

    class C implements Callable <Integer> {
        @Override
        public Integer call() throws Exception {
            TimeUnit.MILLISECONDS.sleep(500);
            return atomicInteger.incrementAndGet();
        }
    }
}
