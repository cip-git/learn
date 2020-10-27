package oc.p._11._2.Annotations.tw;

import java.util.Comparator;

@interface A {

    String value();
}

class C{
    Comparator<String> com = (String c, @A("c2") String c2) -> c.compareTo(c2);
}
