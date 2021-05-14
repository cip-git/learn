package oc.p._11._7_Concurrency.Review_Questions.qs._20;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

class PrintCounter {

    static int count = 0;

    public static void main(String[] args) {
        ExecutorService exec = null;

        try {
            exec = Executors.newSingleThreadExecutor();
            var r = new ArrayList<Future<?>>();

            IntStream
                    .iterate(0, i -> i + 1)
                    .limit(5);

        } finally {
            if (exec != null) exec.shutdown();
        }
    }
}
