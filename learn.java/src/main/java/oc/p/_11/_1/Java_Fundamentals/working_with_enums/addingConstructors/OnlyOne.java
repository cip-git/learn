package oc.p._11._1.Java_Fundamentals.working_with_enums.addingConstructors;

/**
 * The first time that we ask for any of the enum values,
 * Java constructs all of the enum values.
 */
enum OnlyOne {

    ONCE(true);

    OnlyOne(boolean b) {
        System.out.println("constructing,");
    }

}

class R {
    public static void main(String[] args) {
        System.out.println("begin,");
        OnlyOne firstCall = OnlyOne.ONCE;  // prints constructing,
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
        System.out.println("end");

    }
}
