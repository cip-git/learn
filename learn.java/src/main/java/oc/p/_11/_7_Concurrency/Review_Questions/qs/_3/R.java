package oc.p._11._7_Concurrency.Review_Questions.qs._3;

import java.util.concurrent.Callable;

class R {

    Runnable r = () -> System.out.println("r");
    Callable<String> c = () -> "Hello from callable";
}
