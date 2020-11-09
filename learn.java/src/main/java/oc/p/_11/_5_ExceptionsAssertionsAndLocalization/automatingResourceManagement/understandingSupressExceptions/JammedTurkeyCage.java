package oc.p._11._5_ExceptionsAssertionsAndLocalization.automatingResourceManagement.understandingSupressExceptions;

import javax.swing.text.JTextComponent;

class JammedTurkeyCage implements AutoCloseable{

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }

    //bad practice
    private static void m4(){
        try (final JammedTurkeyCage jammedTurkeyCage = new JammedTurkeyCage()){
            throw new IllegalStateException("Turkeys run off");
        }finally {
            throw new RuntimeException("and we couldn't find them");
        }
    }

    private static void m3(){
        try(final JammedTurkeyCage jammedTurkeyCage = new JammedTurkeyCage()){
            throw new RuntimeException("Turkeys run off");
        }catch (IllegalStateException e){
            System.out.println("Caught: " + e.getMessage());
        }
    }

    private static void m2(){
        try (final JammedTurkeyCage jammedTurkeyCage = new JammedTurkeyCage()){
            throw new IllegalStateException("Turkeys run off");
        }catch (IllegalStateException e){
            System.out.println("Caught: " + e.getMessage());
            for (Throwable t: e.getSuppressed()){
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }

    private static void m() {
        try (final JammedTurkeyCage jammedTurkeyCage = new JammedTurkeyCage()) {
            System.out.println("Put turkeys in");
        }catch (IllegalStateException e){
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
