package oc.p._11._7_Concurrency.Identifying_Threading_Problems.starvation;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.print.Print;

class R {

    static class T implements Runnable{
        private int i = 0;
        private String name;
        private Map<String, Integer> map;

        public T(String name, Map<String, Integer> map) {
            this.name = name;
            this.map = map;
        }

        @Override
        public void run() {
            while (true){
                i++;
                map.merge(name, i, (o, n) -> n);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void m() throws InterruptedException {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        final var list = IntStream
                .rangeClosed(1, 10)
                .mapToObj(i -> new T(String.valueOf(i), map))
                .collect(Collectors.toList());

        final var lowPrio = new T("low_prio", map);

        final List<Thread> threadList = list
                .stream()
                .map(t -> {
                    final Thread thread = new Thread(t);
                    thread.setPriority(Thread.MAX_PRIORITY);
                    return thread;
                })
                .collect(Collectors.toList());

        final var lowPrioThread = new Thread(lowPrio);
        lowPrioThread.setPriority(Thread.MIN_PRIORITY);

        threadList.add(lowPrioThread);

        threadList.forEach(Thread::start);

        TimeUnit.SECONDS.sleep(2);

        Print.print(map);
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
