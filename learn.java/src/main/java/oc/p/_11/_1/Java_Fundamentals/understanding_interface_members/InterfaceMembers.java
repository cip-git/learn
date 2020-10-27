package oc.p._11._1.Java_Fundamentals.understanding_interface_members;

@FunctionalInterface
interface InterfaceMembers {

    //public static final; 1.0
    int CONSTANT_VARIABLE = 2;

    //public abstract; 1.0
    void abstractMethod();

    //public; 8.0
    default void defaultMethod(){
        System.out.println("Default method");
    }

    //public; 8.0
    static void staticMethod(){
        System.out.println("Static method");
    }

    // ; 9.0
    private void privateMethod(){
        System.out.println("Private method");
    }

    // ; 9.0
    private static void privateStaticMethod(){
        System.out.println("Private static method");
    }
}

class InterfaceMembersImpl implements InterfaceMembers{

    @Override
    public void abstractMethod() {
    }


}
