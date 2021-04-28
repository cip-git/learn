package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.understanding_the_lock_framework.applying_a_ReentrantLock_interface.duplicate_lock_requests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class R {

    public static void main(String[] args) {
//        m();
        error();
    }

    static void m() {
        Lock lock = new ReentrantLock();

        if (lock.tryLock()) {
            try {
                lock.lock();
                System.out.println("Lock obtained");
            } finally {
                lock.unlock();
            }
        }

        new Thread(() -> System.out.println(lock.tryLock())).start();
    }

    static void error(){
        Lock lock =  new ReentrantLock();

        lock.unlock();
    }
}
