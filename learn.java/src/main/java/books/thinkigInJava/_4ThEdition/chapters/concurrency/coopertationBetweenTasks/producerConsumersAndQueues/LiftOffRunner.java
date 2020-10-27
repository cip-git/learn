package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues;

import books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.definingTasks.LiftOff;

import java.util.concurrent.BlockingQueue;

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    void put(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("put interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                /*
                When there are no  more object in the queue will block until some are produced.
                Instead, when the producer produces more objects than the queue capacity
                will throw an unchecked exception
                 */
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("LiftOffRunner interrupted");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
