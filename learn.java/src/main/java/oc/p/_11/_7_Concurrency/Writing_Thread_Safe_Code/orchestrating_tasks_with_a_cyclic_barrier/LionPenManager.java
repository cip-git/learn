package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.orchestrating_tasks_with_a_cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class LionPenManager {

    void remove(){
        System.out.println("Remove lions");
    }

    void clean(){
        System.out.println("Cleaning the pen");
    }

    void add(){
        System.out.println("Add lions");
    }

    void task(CyclicBarrier cb, CyclicBarrier cb2){
        try {
            remove();
            cb.await();

            clean();
            cb2.await();

            add();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    static void m() throws InterruptedException {
        ExecutorService exec = null;

        try {

            exec = Executors.newCachedThreadPool();
            var manager = new LionPenManager();

            var cb = new CyclicBarrier(4, () -> System.out.println("*** Lions removed!"));
            var cb2 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!"));


            for(int i=0; i<4; i++){
                exec.submit(() -> manager.task(cb, cb2));
            }

        }finally {
            if(exec != null){
                exec.shutdown();
            }
        }

        if(exec != null){
            exec.awaitTermination(1, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
