package oc.p._11.qs.enthuware.standard_test._1._32;

import java.util.function.Supplier;

class Employee {
    int age;
}

class R {

    public static void main(String[] args) {
        final Employee e = new Employee();

        Supplier<Employee> se = () -> {
            e.age = 40;
            return e;
        };

        e.age = 50;

        System.out.println(se.get().age);
    }
}


