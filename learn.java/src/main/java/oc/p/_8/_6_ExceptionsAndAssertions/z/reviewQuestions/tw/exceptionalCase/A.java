package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions.tw.exceptionalCase;

import java.sql.SQLException;

/**
 * Same behavior as for the case when no exception is being thrown in the try body
 */
class A {

    void e () throws SQLException{
        throw new SQLException();
    }


    void m() throws SQLException{
        try{
            e();
        }catch (Exception e){
//            throw e;
            throw e;
        }
    }

    void m2() throws SQLException{
        try {
            e();
        }catch (RuntimeException e){
//            throw e;
            throw e;
        }
    }

    void m3() throws SQLException{
        try{
            e();
        }catch (Throwable t){
            throw t;
        }
    }

//    void m4() throws SQLException{
//        try {
//            e();
//        }catch (IOException e){
//            throw  e;
//        }
//    }
}
