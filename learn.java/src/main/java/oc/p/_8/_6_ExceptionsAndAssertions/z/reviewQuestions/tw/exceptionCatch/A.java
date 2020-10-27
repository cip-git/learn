package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions.tw.exceptionCatch;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

class A {

    static void m(){
        try{

        }catch (Exception e){
        }
    }

    static void m2(){
        try{

        }catch (RuntimeException e){}
    }

    static void m3(){
        try {

        }catch (Throwable t){}
    }

    static void m4(){
        try{

        }catch (Error e){}
    }

    static void m5(){
//        try{}catch (IOException e){}

//        try{}catch (SQLException e){}

//        try{}catch (ParseException e){}

        try{}catch (NullPointerException e){}

        try{}catch (IndexOutOfBoundsException e){}

        try{}catch (ArrayIndexOutOfBoundsException e){}
    }


}
