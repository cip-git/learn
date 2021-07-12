package oc.p._11.qs.enthuware.foundation_test._2._27;

class R {

    public static void main(String[] args) {

        int i = 0;
        int j = 0;

        boolean bool;

        bool = (false & method1(i++));  //0
        bool = (false & method1(++j));  //1

        System.out.println();

        System.out.println(i);  //1
        System.out.println(j);  //1
    }

    public static boolean method1(int i) {
        System.out.println(i);

        return i > 0;
    }
}
