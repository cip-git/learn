package oc.a.oracle.chapters.c_3_lexicalStructure.literals.string;

import java.time.LocalDateTime;
class A{
    @Override
    public String toString() {
        return "A{}";
    }
}

class B{
    @Override
    public String toString() {
        return "B{}";
    }
}

class Format {

    static void m(){
        String s = "bla %1$s [%1$s] {%2$s}  bla  bla %3$s, bla";
        String s2 = String.format(s, new A(), new B(), 3);
        System.out.println(s2);
    }

    public static void main(String[] args) {
        m();
    }
}
