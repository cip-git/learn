package oc.p._11._1.Java_Fundamentals.understanding_interface_members.staticMethods;

interface Walk {

    static int speed(){
        return 5;
    }
}

interface Run{

    //not part of the implementing class;
    // in this way in java solved the multiple inheritance problem
    static int speed(){
        return 10;
    }
}

class Cat implements Walk, Run{

    void m(){
//        System.out.println(speed());

        System.out.println(Walk.speed());
        System.out.println(Run.speed());
    }
}
