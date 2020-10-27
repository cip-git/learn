package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CarBuilder {

    public static void main(String[] args) throws InterruptedException {
        CarQueue chassisQueue = new CarQueue(),
                finishingCarQueue = new CarQueue();

        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue, finishingCarQueue, robotPool));
        exec.execute(new Reporter(finishingCarQueue));
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
