package oc.p._11._3.genericsAndCollections.reviewQuestions.qs._3;

import java.util.List;

class R {

    static void m(){
        List<?> q = List.of("mouse", "parrot");
        var v = List.of("mouse", "parrot");

//        q.removeIf(String::isEmpty);
//        q.removeIf(s -> s.length() == 4);

        v.removeIf(String::isEmpty);
        v.removeIf(s -> s.length() == 4);

        var var = 2;

//        int int = 2;  //CE
    }
}
