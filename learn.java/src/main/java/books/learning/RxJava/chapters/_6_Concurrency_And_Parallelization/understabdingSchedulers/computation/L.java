package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understabdingSchedulers.computation;

/**
 * Schedulers.computation().
 * This will maintain a fixed number of threads based on the processor count available
 * to your Java session, making it appropriate for computational tasks.
 * Computational tasks (such as math, algorithms, and complex logic) may utilize cores to
 * their fullest extent.
 * Therefore, there is no benefit in having more worker threads than available cores
 * to perform such work, and the computational Scheduler will ensure that.
 */
class L {


}
