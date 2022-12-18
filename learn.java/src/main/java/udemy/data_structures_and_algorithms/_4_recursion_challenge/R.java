package udemy.data_structures_and_algorithms._4_recursion_challenge;

import java.util.Arrays;

class R {

    //int arr[] = { 1, 2, 3, 4, 5 };
    //productofArray(arr, arr.length); #120

    static int productOfArray(int A[], int N) {
        if (N == 1) {
            return A[0];
        }
        return A[N - 1] * productOfArray(A, N - 1);
    }

    //recursiveRange(6)  // 21
    static int recursiveRange(int num) {
        if (num == 0) {
            return 0;
        }
        return num + recursiveRange(num - 1);
    }

    //    fib(4) # 3 // 0 1 1 2 3 5 8 13 21
//    fib(10) # 55
//    fib(28) # 317811
//    fib(35) # 9227465
    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //    reverse('java') # 'avaj'
//    reverse('appmillers') # 'srellimppa'
    //
    static String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }
        return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    //    isPalindrome('awesome') # false
//    isPalindrome('foobar') # false
//    isPalindrome('tacocat') # true
//    isPalindrome('amanaplanacanalpanama') # true
//    isPalindrome('amanaplanacanalpandemonium') # false
    static boolean isPalindrome(String s) {
        if (s.length()==0 || s.length() == 1){
            return true;
        }
        return s.charAt(0) == s.charAt(s.length() -1) & isPalindrome(s.substring(1, s.length()-1));
    }

    static class OddFunction {
        boolean run(int num) {
            if (num % 2 == 0) {
                return false; }
            else {
                return true;
            }
        }
    }

//    someRecursive({1,2,3,4}, isOdd) # true
//    someRecursive({4,6,8,9}, isOdd) # true
//    someRecursive({4,6,8}, isOdd) # false

    static boolean someRecursive(int[] arr, OddFunction odd) {
        if(arr.length == 0){
            return false;
        }
        if(arr.length == 1){
            return odd.run(arr[0]);
        }
        return odd.run(arr[0]) || someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
    }

    //appmillerS -> S
    static char first(String str) {
        if(str.length()==0){
            return 0;
        }
        char c = str.charAt(0);
        if (c >= 'A' && c <= 'Z'){
            return c;
        }
        return first(str.substring(1));
    }

//    input: i love java
//    output : I Love Java

    static String capitalizeWord(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }
        int i = str.indexOf(" ");
        if(i >0){
            return str.substring(0, 1).toUpperCase() + str.substring(1, i+1) + capitalizeWord(str.substring(i+1));
        }else{
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    public static void main(String[] args) {
//        int product = productOfArray(new int[]{1, 2, 3, 4, 5}, 5);
//        System.out.println(product);
//
//        System.out.println(recursiveRange(6));
//
//        System.out.println(fib(35));
//
//        System.out.println(reverse("appmillers"));
//
//        System.out.println(isPalindrome("foobar"));
//
//        someRecursive();

//        System.out.println(first("appmillerS"));

        System.out.println(capitalizeWord("i love java"));
    }

    private static void someRecursive() {
        System.out.println(someRecursive(new int[]{1,2,3,4}, new OddFunction()) );
        System.out.println(someRecursive(new int[]{4,6,8,9}, new OddFunction()) );
        System.out.println(someRecursive(new int[]{4,6,8}, new OddFunction()) );
    }
}
