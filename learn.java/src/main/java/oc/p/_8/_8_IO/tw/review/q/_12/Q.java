package oc.p._8._8_IO.tw.review.q._12;

import java.io.File;

class Q {

    void m(){
//        File f = new File("c:\book\java");

        File f = new File("c:\\book\\java");

        File f2 = new File("c:/book/java");

        File f3 = new File("c://book//java");

        System.out.println(f);
        System.out.println(f2);
        System.out.println(f3);
    }

    public static void main(String[] args) {
        new Q().m();
    }
}
