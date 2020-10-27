package oc.p._11._2.Annotations.using_common_annotations.safeVarargs;

/**
 * Marker annotation
 *
 * @SafeVarargs can only be applied to constructor and private/static/final method,
 * if the last parameter in the params list is a vararg
 *
 * It also suppresses unchecked compiler warnings for the varargs parameter.
 *
 */

class Info {

    @SafeVarargs
    Info(String... varargs){
    }

    @SafeVarargs
    private void pm(int... varargs){

    }

    @SafeVarargs
    static void sm(int... varargs){

    }

    @SafeVarargs
    final void fm(int... varargs){

    }
}

//@SafeVarargs
class NotCompile{
//    @SafeVarargs
    NotCompile(){}

//    @SafeVarargs
   void m(int... varargs){

    }

//    @SafeVarargs
    protected void m2(int... varargs){}
}
