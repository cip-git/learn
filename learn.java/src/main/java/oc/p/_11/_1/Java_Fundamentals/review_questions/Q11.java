package oc.p._11._1.Java_Fundamentals.review_questions;

import java.time.LocalDateTime;

class Q11 {

    {
        var var = LocalDateTime.now();
        int i = 2;
        String String  = "String";
        LocalDateTime LocalDateTime = var;
    }

    interface CanWalk{
        default void walk(){
            System.out.println("Wolking");
        }

        private void testWalk(){}
    }


    interface CanRun{
        abstract public void run();

        private void testWalk(){}

        default void walk(){
            System.out.println("Running");
        }
    }

    interface CanSprint extends CanWalk, CanRun{
        @Override
        default void walk() {
            CanRun.super.walk();
        }
    }

    abstract class AC implements CanWalk, CanRun{
        @Override
        public void walk() {
            CanWalk.super.walk();
        }
    }
}

