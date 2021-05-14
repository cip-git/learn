package oc.p._11._7_Concurrency.Review_Questions.qs._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class Bank {

    private Lock vault = new ReentrantLock();
    private int total = 0;

    void deposit(int value){
        try{
            vault.tryLock();
            total += value;
        }finally {
            vault.unlock();
        }
    }

    public static void main(String[] args) {
        var bank = new Bank();

        IntStream
                .range(1, 10)
                .parallel()
                .forEach(bank::deposit);

        System.out.println(bank.total);
    }
}
