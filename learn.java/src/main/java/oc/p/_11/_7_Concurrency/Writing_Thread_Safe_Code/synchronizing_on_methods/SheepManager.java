package oc.p._11._7_Concurrency.Writing_Thread_Safe_Code.synchronizing_on_methods;

class SheepManager {

    private int sheepCount = 0;

    /**
     * incrementAndGet() == incrementAndGetV2()
     */
    void incrementAndGet() {
        synchronized (this) {
            System.out.println(++sheepCount + " ");
        }
    }

    synchronized void incrementAndGetV2() {
        System.out.println(++sheepCount + " ");
    }

    /**
     * printDaysWork() == printDaysWorkV2()
     */

    static void printDaysWork(){
        synchronized (SheepManager.class){
            System.out.println("Finished work");
        }
    }

    static synchronized void printDaysWorkV2(){
        System.out.println("Finished work");
    }
}
