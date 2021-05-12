package oc.p._11._7_Concurrency.Identifying_Threading_Problems.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Food {
}

class Water {
}

class Fox {

    void eatAndDrink(Food food, Water water){
        synchronized (food){
            System.out.println("Got food");
            move();
            synchronized (water){
                System.out.println("Got water");
            }
        }
    }

    void drinkAndEat(Food food, Water water){
        synchronized (water){
            System.out.println("Got water");
            move();
            synchronized (food){
                System.out.println("Got food");
            }
        }
    }

    void move(){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static void m(){
        Fox foxy = new Fox();
        Fox tail = new Fox();

        Food food = new Food();
        Water water = new Water();

        ExecutorService executor = null;

        try {
            executor = Executors.newFixedThreadPool(10);

            executor.submit(() -> foxy.eatAndDrink(food, water));
            executor.submit(() -> tail.drinkAndEat(food, water));
        }finally {
            if (executor != null) executor.shutdown();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
