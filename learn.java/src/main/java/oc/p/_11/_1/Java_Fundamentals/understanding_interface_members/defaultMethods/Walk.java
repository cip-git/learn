package oc.p._11._1.Java_Fundamentals.understanding_interface_members.defaultMethods;

interface Walk {
    default int speed(){
        return 5;
    }
}

interface Run{
    default int speed(){
        return 10;
    }
}

class Cat implements Walk, Run{

    @Override
    public int speed() {
        return Walk.super.speed();
    }

    public static void main(String[] args) {
        System.out.println(new Cat().speed());
    }
}

class T extends Thread{

}