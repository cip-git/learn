package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw._2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Restaurant {

    volatile int nbOfOrder = 0;
    Meal meal;
    Chef chef;
    Waiter waiter;
    ExecutorService executorService;

    public Restaurant() {
        this.executorService = Executors.newCachedThreadPool();
        chef = new Chef(this);
        waiter = new Waiter(this);
    }

    void run(){
        executorService.submit(chef);
        executorService.submit(waiter);
    }

    public static void main(String[] args) {
        new Restaurant().run();
    }
}
