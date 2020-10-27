package oc.p._8._6_ExceptionsAndAssertions.z.reviewQuestions;

import java.io.Closeable;
import java.io.IOException;

class Q5 {

    static class Door implements AutoCloseable{
        @Override
        public void close(){
            System.out.println("D");
        }
    }

    static class Window implements Closeable{
        @Override
        public void close(){
            System.out.println("W");
            throw new RuntimeException("RE");
        }
    }

    public static void main(String[] args) {
        try (
                Door d= new Door();
                Window w = new Window();
        ){
            System.out.println("T");
        }catch (Exception e){
            System.out.println("\n");
            System.out.println(e.getMessage());
            System.out.println("\n");
            System.out.println("E");
        }finally {
            System.out.println("F");
        }
    }
}
