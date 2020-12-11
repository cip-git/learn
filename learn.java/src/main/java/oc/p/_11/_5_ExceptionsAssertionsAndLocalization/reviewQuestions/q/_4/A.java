package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._4;

import java.util.Optional;

class A0{
    public A0() {

        System.out.println("A0");
    }
}

class A extends A0 {

    public A(){
        System.out.println("A");
    }

    public static void main(String[] args) {
        new A();

        final Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }
}
