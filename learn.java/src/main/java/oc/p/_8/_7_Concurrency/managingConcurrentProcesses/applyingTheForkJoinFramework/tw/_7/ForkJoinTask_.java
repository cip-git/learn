package oc.p._8._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._7;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * The ForkJoinTask abstract class doesn't have the compute method,
 * so that only means that the compute method is defined both
 * for RecursiveAction and RecursiveTask
 */
abstract class ForkJoinTask_<E> extends ForkJoinTask <E> {

}

abstract class RecursiveTask_<E> extends RecursiveTask <E> {
    @Override
    protected E compute() {
        return null;
    }
}

abstract class RecursiveAction_ extends RecursiveAction {
    @Override
    protected void compute() {

    }


}