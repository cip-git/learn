package udemy.data_structures_and_algorithms._2_recursion.recursive_vs_iterative;

class R {

    static int powerOf2Rec(int n){
        if(n == 0){
            return 1;
        }
        return 2 * powerOf2Rec(n -1);
    }

    static int powerOf2It(int n){
        var power = 1;
        for(int i = 0; i< n; i++){
            power = power *2; //2, 4, 8, 16
        }
        return power;
    }

    public static void main(String[] args) {
        System.out.println(powerOf2Rec(4));
        System.out.println(powerOf2It(4));
    }
}
