package oc.p._8._8_IO.tw.review.q._21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Zebra implements Serializable {
    private static final long longSerialUID = 1;
    private static String birthPlace = "Africa";
    private transient String name = "George";
    private transient Integer age;
    private List <Zebra> friends = new ArrayList <>();
    private Object tail = null;

    {
        age = 10;
    }

    Zebra() {
        this.name = "Sophia";
    }

    static long getLongSerialUID() {
        return longSerialUID;
    }

    static String getBirthPlace() {
        return birthPlace;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    List <Zebra> getFriends() {
        return friends;
    }

    Object getTail() {
        return tail;
    }
}
