package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions;

class Q12 {

    static class SneezeException extends Exception { }
    static class SniffleException extends SneezeException { }

    static void m() throws SneezeException{
        try {
            throw new SneezeException();
        }catch (SneezeException e){
//            e = new Exception();
//            e = new RuntimeException();
            e = new SneezeException();
            e = new SniffleException();
            throw e;
        }
    }
}
