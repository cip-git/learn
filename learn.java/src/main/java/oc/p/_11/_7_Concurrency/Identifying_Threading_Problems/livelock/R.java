package oc.p._11._7_Concurrency.Identifying_Threading_Problems.livelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Food {
}

class Water {
}

class Fox{

    private String name;

    public Fox(String name) {
        this.name = name;
    }

    void eatAndDrink(
            Lock foodLock,
            Food food,
            Lock waterLock,
            Water water){

        var ate = false;
        var drinked = false;

        while (!ate && !drinked){
            ate = false;
            drinked = false;
            try {
                if(foodLock.tryLock(100, TimeUnit.MILLISECONDS)){
                    System.out.println(name + " got food");
                    ate = true;

                    move();

                        if(waterLock.tryLock(100, TimeUnit.MILLISECONDS)){
                            System.out.println(name + " got water");
                            drinked = true;
                        }else {
                            waterLock.unlock();
                        }

                }else{
                    foodLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void drinkAndEat(
            Lock foodLock,
            Food food,
            Lock waterLock,
            Water water){

        var ate = false;
        var drinked = false;

        while (!ate && !drinked){
            ate = false;
            drinked = false;
            try {
                if(waterLock.tryLock(100, TimeUnit.MILLISECONDS)){
                    System.out.println(name + " got water");
                    drinked = true;

                    move();

                    if(foodLock.tryLock(100, TimeUnit.MILLISECONDS)){
                        System.out.println(name + " got food");
                        ate = true;
                    }else {
                        foodLock.unlock();
                    }

                }else{
                    waterLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    void move(){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

class R {

    static void m(){
        final Food food = new Food();
        final Water water = new Water();

        final ReentrantLock foodLock = new ReentrantLock();
        final ReentrantLock waterLock = new ReentrantLock();

        final Fox foxy = new Fox("Foxy");
        final Fox tail = new Fox("tail");

        ExecutorService exec = null;

        try {

            exec = Executors.newCachedThreadPool();

            exec.submit(() -> foxy.eatAndDrink(foodLock, food, waterLock, water));
            exec.submit(()-> tail.drinkAndEat(foodLock, food, waterLock, water));

            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(exec != null) exec.shutdown();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
