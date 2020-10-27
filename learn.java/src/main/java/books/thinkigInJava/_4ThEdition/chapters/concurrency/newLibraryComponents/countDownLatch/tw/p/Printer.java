package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw.p;

import java.util.concurrent.CountDownLatch;

class Printer implements Runnable{
    private Square square;
    private CountDownLatch countDownLatch;

    public Printer(Square square, CountDownLatch countDownLatch) {
        this.square = square;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            countDownLatch.await();
//            System.out.println(this.getClass().getSimpleName() + " " +Thread.currentThread().getId());
            square.print();
        }catch(InterruptedException e){
            System.out.println("Printer interrupted");
        }
    }
}
