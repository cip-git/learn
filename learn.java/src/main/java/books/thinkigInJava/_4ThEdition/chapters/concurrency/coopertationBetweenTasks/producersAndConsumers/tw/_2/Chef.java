package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw._2;

import java.util.concurrent.TimeUnit;

class Chef implements Runnable {

    Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }

                synchronized (restaurant.waiter) {
                    restaurant.meal = new Meal(++restaurant.nbOfOrder);
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("Order's ready");
                    restaurant.waiter.notifyAll();
                    if (restaurant.nbOfOrder == 5) {
                        restaurant.executorService.shutdownNow();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
