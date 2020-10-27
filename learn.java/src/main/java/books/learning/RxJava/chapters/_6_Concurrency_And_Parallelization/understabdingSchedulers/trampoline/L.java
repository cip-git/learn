package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understabdingSchedulers.trampoline;

/**
 * Schedulers.trampoline().
 * In practicality, you will not invoke it often as it is used primarily in RxJava's internal
 * implementation.
 * Its pattern is also borrowed for UI Schedulers such as RxJavaFX and RxAndroid.
 * It is just like default scheduling on the immediate thread, but it prevents cases of
 * recursive scheduling where a task schedules a task while on the same thread.
 * Instead of causing a stack overflow error,
 * it will allow the current task to finish and then execute that new scheduled task afterward.
 */
class L {
}
