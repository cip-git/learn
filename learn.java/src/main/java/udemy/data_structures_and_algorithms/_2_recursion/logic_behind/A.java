package udemy.data_structures_and_algorithms._2_recursion.logic_behind;

class A {

    static void m() {
        System.out.println("method 1");
        m2();
    }

    static void m2() {
        System.out.println("method 2");
        m3();
    }

    static void m3() {
        System.out.println("method 3");
        m4();
    }

    static void m4() {
        System.out.println("method 4");
    }

    static void recM(int n) {
        if (n < 1) {
            System.out.println("n is less than 1");
        } else {
            recM(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
//        m();
        recM(4);
    }
}
