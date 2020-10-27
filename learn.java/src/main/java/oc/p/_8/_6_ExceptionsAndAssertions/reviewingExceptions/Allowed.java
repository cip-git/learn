package oc.p._8._6_ExceptionsAndAssertions.reviewingExceptions;

class Allowed {
    static void m() {
        try {

        } catch (Throwable t) {
        }
    }

    static void m2() {
        try {

        } catch (Exception e) {
        }
    }

    static void m3() {
        try {

        } catch (Error e) {
        }
    }

    static void m4() {
        try {

        } catch (RuntimeException e) {
        }
    }


    /**
     * All checked exceptions excepting Exception will throw a compiler error
     */
//    static void m5(){
//        try {
//
//        }catch (SQLException e){}
//    }
}
