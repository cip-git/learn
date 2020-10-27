package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards;

import java.time.ZonedDateTime;

import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

class Need {

    static void array() {
        E[] ea = new E[2];
        ea[0] = new E();
        ea[1] = new F();

        Object[] oa = ea;

        String[] sa;
//      sa = (String[]) oa;  //RE: ClassCastException

        sa = new String[]{"a", "b"};
        ea = (E[]) ((Object[]) sa);   //RE: ClassCastException;
    }

    static void m(){
        E[] es = new E[3];
        es[0] = new E();
        es[1] = new F();

        Object[] os = es;

//        os[2] = ZonedDateTime.now();  //ArrayStoreException

        for(E e: es){
            System.out.println(e);
        }

//        the [] knows the contained type at runtime
        for (Object o: os){
            System.out.println(o);
        }


        //[] doesn't know the type at compile time, only at runtime
        String[] ss = (String[]) os;  //ClassCastException
    }

    public static void main(String[] args) {

        m();
//        array();
    }
}
