package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.understanding_the_lock_framework.applying_a_ReentrantLock_interface.tryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class R {


    static void m(){
        Lock lock = new ReentrantLock();

        new Thread(() -> printMessage(lock)).start();

        if(lock.tryLock()){
            try {
                System.out.println("Lock acquired. Entering protected code");
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("Unable to acquire lock");
        }
    }

    private static void printMessage(Lock lock) {
        try{
            lock.lock();
            System.out.println("Print message");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
