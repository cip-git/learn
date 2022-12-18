package udemy.data_structures_and_algorithms._3_recursion_interview.sum_of_digits;

class R {

    /**
     * Steps
     * <p>
     * 1. Condition
     * 10/10 = 1 r 0,
     * 100/10 = 10, r 0
     * 344 /10 = 34, 4
     * 34/10 = 3, r 4
     * <p>
     * 2. Stop condition
     * <p>
     * 3. Unintentional case - the constraint
     */

    static int sumOfDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(344));
        System.out.println(sumOfDigits(591));
        System.out.println(sumOfDigits(768));
        System.out.println(sumOfDigits(54));
        System.out.println(sumOfDigits(112));
    }
}
