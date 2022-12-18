package udemy.data_structures_and_algorithms._3_recursion_interview.power_of_a_nb;

class R {

    /**
     * 2^3 = 2 * 2^2
     */
    static int powerOfANumber(int n, int pow) {
        if (pow < 0) {
            return -1;
        }
        if (pow == 0) {
            return 1;
        }
        return n * powerOfANumber(n, pow - 1);
    }

    public static void main(String[] args) {
        System.out.println(powerOfANumber(2, 3));
    }
}
