package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.understanding_the_lock_framework.applying_a_ReentrantLock_interface.tryLock_timeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class R {

    static void m() throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Thread(() -> printMessage(lock)).start();

        if(lock.tryLock(1, TimeUnit.SECONDS)){
            try {

                System.out.println("Lock acquired. Entering protected code");
            }finally {
                lock.unlock();
            }
        }else {
            System.out.println("Unable to acquire lock");
        }
    }

    private static void printMessage(Lock lock) {
        try{
            lock.lock();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Print message");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
