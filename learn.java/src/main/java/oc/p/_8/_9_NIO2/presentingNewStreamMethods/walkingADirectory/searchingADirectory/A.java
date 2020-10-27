package oc.p._8._9_NIO2.presentingNewStreamMethods.walkingADirectory.searchingADirectory;

import java.util.ArrayList;
import java.util.List;

class A {

    static int fib(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;

        int i = 2;
        while( i<= n){
            c = a + b;
            a = b;
            b = c;
            i = i +1;
        }

        return b;
    }

    public static void main(String args[]) {
        int n = 9;
        System.out.println(fib(n));

    }
}
