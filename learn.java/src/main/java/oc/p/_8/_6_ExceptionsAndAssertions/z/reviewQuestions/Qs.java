package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions;

import java.io.FileNotFoundException;
import java.io.IOException;

class Qs {

    static class AC implements AutoCloseable{
        @Override
        public void close()  {

        }
    }

    static void m4(){
        try(AC ac = new AC()){}
    }

    static void m5(){

    }
}
