package oc.p._11._2.Annotations.review_questions.q._16;

import java.util.ArrayList;
import java.util.List;

class Donkey {

    @SafeVarargs
    public /*protected*/ /*private*/ Donkey(int... is) {  //all ok, including package protected
    }

    @SuppressWarnings("unchecked")
    public String kick(List... t){
        t[0] = new ArrayList();
        t[0].add(1);

        return (String)t[0].get(0);
    }
}
