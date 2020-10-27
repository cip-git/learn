package books.learning.RxJava.chapters._2_Observables_and_Subscribers.theObservable.howObservablesWork;

/**
 * onNext(): This passes each item one at a time from the source Observable all the way
 * down to the Observer.
 *
 * onComplete(): This communicates a completion event all the way down to the Observer,
 * indicating that no more onNext() calls will occur.
 *
 * onError(): This communicates an error up the chain to the Observer,
 * where the Observer typically defines how to handle it.
 *Unless a retry() operator is used to intercept the error,
 * the Observable chain typically terminates, and no more emissions will occur.
 */
class Info {

}
