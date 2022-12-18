package udemy.data_structures_and_algorithms._3_recursion_interview.decimal_to_binary;

class R {

    /**
     * 1. Recursive case
     * 8/2 = 4, 0
     * 4/2 = 2, 0
     * 2/2 = 1, 0
     * 1/2 = 0, 1
     * <p>
     * // 1000
     * <p>
     * 2. Stop condition
     */
    static String decimalToBinary(int n) {
        if (n == 0) {
            return "";
        }
        return decimalToBinary(n / 2) + n % 2;
    }


    static int decimalToBinary2(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 2 + 10 * decimalToBinary2(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(8));
        System.out.println(decimalToBinary(16));
        System.out.println(decimalToBinary(32));
        System.out.println(decimalToBinary(35));

        System.out.println();

        System.out.println(decimalToBinary2(8));
        System.out.println(decimalToBinary2(16));
        System.out.println(decimalToBinary2(32));
        System.out.println(decimalToBinary2(35));
    }
}
