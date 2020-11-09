package oc.p._11._5_ExceptionsAssertionsAndLocalization.automatingResourceManagement.understandingSupressExceptions;

class TurkeyCage implements AutoCloseable{

    @Override
    public void close() {
        System.out.println("Close gate");
    }

    public static void main(String[] args) {
        try(var t = new TurkeyCage()){
            System.out.println("Put turkey in");
        }
    }
}
