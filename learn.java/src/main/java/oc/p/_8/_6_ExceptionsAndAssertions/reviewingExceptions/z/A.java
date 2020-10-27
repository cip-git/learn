package oc.p._8._6_ExceptionsAndAssertions.reviewingExceptions.z;

import java.io.FileNotFoundException;
import java.io.IOException;

class A {

    boolean b = false;

    int m() {
        try {
            if (b) {
                throw new FileNotFoundException();
            }
            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
//            throw new Exception(e); //also Ok, but the Exception needs to be declared in the method signature
        }
    }

    void m2() {
        System.out.println(m());
    }
}
