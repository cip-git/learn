package oc.p._8._6_ExceptionsAndAssertions.z.practice_tests;

import java.io.Closeable;

class Q11 {
    class Printer implements Closeable{

        void print(){
            System.out.println("This just in");
        }

        @Override
        public void close(){
        }
    }

    void printHeaders(){
        try(Printer p = new Printer()){
            p.print();
        }
    }

    public static void main(String[] args) {
        new Q11().printHeaders();
    }
}
