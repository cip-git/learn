package oc.p._11._1.Java_Fundamentals.review_questions;


enum  Es {

    A, B, C, D;

    void m() {
//        enum A {}  //compiler error

    }

    static void m2() {
//        enum A{}  //compiler error
    }
}

class Run{

    static void m(){
        Es e = null;

        switch (e){
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            default:
                System.out.println("tralala");
        }
    }

    public static void main(String[] args) {
        m();
    }
}
