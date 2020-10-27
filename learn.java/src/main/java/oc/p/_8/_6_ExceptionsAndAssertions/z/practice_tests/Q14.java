package oc.p._8._6_ExceptionsAndAssertions.z.practice_tests;

class Q14 {

    class MissingMoneyException extends Exception{}

    class MissingFoodException extends Exception{}

    void doIhaveAProblem() throws MissingMoneyException, MissingFoodException {
        System.out.println("No problem");
    }

    public static void main(String[] args) throws MissingMoneyException, MissingFoodException {
        try{
            Q14 q = new Q14();
            q.doIhaveAProblem();
        }catch (Exception e){
            RuntimeException re = new RuntimeException(e);
            throw re;
        }
    }


    static void m(){
        try{

        }catch (Exception e){
            throw e;
        }
    }

    static void m2(){
        try {

        }catch (RuntimeException e){
            throw  e;
        }
    }

    static void m3(){
        try {

        }catch (Throwable t){
            throw t;
        }
    }

    static void m4(){
        try {

        }catch (Error e){
            throw  e;
        }
    }
}
