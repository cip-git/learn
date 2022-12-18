package udemy.data_structures_and_algorithms._3_recursion_interview.gcd;

class R {


    static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(8, 12));
        System.out.println(gcd(12, 8));
        System.out.println(gcd(48, 18));
        System.out.println(gcd(0, 0));
    }
}
