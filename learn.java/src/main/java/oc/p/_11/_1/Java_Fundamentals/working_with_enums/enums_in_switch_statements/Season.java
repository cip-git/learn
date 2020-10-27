package oc.p._11._1.Java_Fundamentals.working_with_enums.enums_in_switch_statements;

enum Season {
    A, B, C
}

class R {

    static void m() {
        Season s = Season.A;

        switch (s) {
            case A:
                break;
            case B:
                break;
//            case Season.C:  //compiler error: java already knows the type
            default:
                break;
        }
    }
}
