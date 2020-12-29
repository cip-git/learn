package oc.p._11._5_ExceptionsAssertionsAndLocalization.automatingResourceManagement.newEffectiveFinalFeature;

import java.util.List;

import oc.a.chapters._5_class_design.implementingInterfaces.inheritingAnInterface.case2.AC;

class R2 {

    static class E implements AutoCloseable{
        @Override
        public void close() throws Exception {
            throw new RuntimeException("E");
        }
    }

    static class D implements AutoCloseable{
        @Override
        public void close() throws Exception {
            throw new RuntimeException("D");
        }
    }

    static void m(){
        D d = new D();
        try(E e = new E(); d){
            throw new Exception("m");
        }catch (Exception e){
            System.out.println(e.getMessage());
            List
                    .of(e.getSuppressed())
                    .forEach(t -> System.out.println(t.getMessage()));
        }
    }

    public static void main(String[] args) {
        m();
    }
}
