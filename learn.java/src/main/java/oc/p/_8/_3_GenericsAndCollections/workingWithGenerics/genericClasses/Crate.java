package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericClasses;

class Crate<T> {
    private T content;

    void pack(T t) {
        this.content = t;
    }

    T unPack() {
        return content;
    }

/**
 * Not allowed because the type T is bonded to the instance of the class
  */
//    static T m(){
//        return t;
//    }
}

/*
    This how this class looks like after compiling
    This means there is only one class directory. There aren’t different copies for different
parameterized types.

public class Crate{
    private Object content;

    void pack(Object t){
        this.content = t;
    }

    Object unPack(){
        return content;
    }
}
 */
