package books.learning.RxJava.chapters._6_Concurrency_And_Parallelization.understabdingSchedulers.io;


/**
 * IO tasks such as reading and writing databases, web requests,
 * and disk storage are less expensive on the CPU and often have idle time waiting for the data
 * to be sent or come back.
 * This means you can create threads more liberally, and Schedulers.io() is appropriate for this.
 * It will maintain as many threads as there are tasks and will dynamically grow, cache,
 * and reduce the number of threads as needed.
 * For instance, you may use Schedulers.io() to perform SQL operations using
 * RxJava-JDBC (https://github.com/davidmoten/rxjava -jdbc):
 */
class L {
}
