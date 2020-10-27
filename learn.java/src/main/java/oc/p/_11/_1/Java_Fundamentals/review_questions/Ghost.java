package oc.p._11._1.Java_Fundamentals.review_questions;

public class Ghost {

    static void boo(){
        System.out.println("Not scared");
    }

    void a(){
    }

    protected final class Spirit{
        void boo(){
            System.out.println("Boo");
        }
    }

    public static void main(String[] args) {
//        var g = new Ghost().new Spirit() {}; //can't be extended since the class marked final


        //ok
//        var g = new Ghost().new Spirit() ;

//        g.boo();  //Boo

//        g.super.boo();  //CE

//        new Ghost().boo();  //Not scared

//        g.Ghost.boo();  //CE

//        new Spirit().boo();  //CE

//        Ghost.boo();  //NOt scared
    }
}
