package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understabdingSchedulers.startingAndShuttingDownSchedulers;

/**
 * Each default Scheduler is lazily instantiated when
 * you first invoke its usage.
 * You can dispose the computation(), io(), newThread(), single(), and trampoline() Schedulers
 * at any time by calling their shutdown() method or all of them by calling Schedulers.shutdown().
 * This will stop all their threads and forbid new tasks from coming in and will throw an error
 * if you try otherwise.
 * You can also call their start() method, or Schedulersers.start(),
 * to reinitialize the Schedulers so they can accept tasks again
 */
class L {
}
