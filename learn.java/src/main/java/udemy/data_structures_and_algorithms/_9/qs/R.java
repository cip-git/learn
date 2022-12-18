package udemy.data_structures_and_algorithms._9.qs;

import java.util.Arrays;

class R {

    public static void main(String[] args) {
//        missingNumber(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10});

//        System.out.println(isUnique(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10}));

        int[][] matrix = new int[][]{
                {1, 2, 3}, //
                {4, 5, 6},
                {7, 8, 9}};

        rotateMatrix(matrix);
    }

    /**
     * (0, 0) -> (0, 2)
     * (0, 1) -> (1, 2)
     * (0, 2) -> (2, 2)
     *
     * (1, 0) -> (0, 1)
     * (1, 1) -> (1, 1)
     * (1, 2) -> (2, 1)
     *
     * (2, 0) -> (0, 0)
     * (2, 1) -> (1, 0)
     * (2, 2) -> (2, 0)
     */
    static boolean rotateMatrix(int[][] matrix) {

        int x = matrix.length;
        int y = matrix[0].length;

        int[][] res = new int[y][x];

        for(int i = 0; i<x; i++){
            for(int j = 0; j< y; j++){
                int xn = j;
                int yn = x-1-i;
                res[xn][yn] = matrix[i][j];
            }
        }
        String s = Arrays.deepToString(res);
        System.out.println(s);
        return true;

    }

    static boolean permutation(int[] array1, int[] array2) {
        A:
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    continue A;
                }
            }
            return false;
        }
        return true;
    }

    static boolean isUnique(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }


    //    int[] intArray = {10,20,30,40,50};
//    maxProduct(intArray) // (40,50)
    static String maxProduct(int[] intArray) {
        int l = intArray.length;
        int[] arr = new int[2];
        arr[0] = Integer.MIN_VALUE;
        arr[1] = Integer.MIN_VALUE;

        for (int i = 0; i < l; i++) {
            if (intArray[i] > arr[0]) {
                arr[0] = intArray[i];
            } else if (intArray[i] > arr[1]) {
                arr[1] = intArray[i];
            }
        }
        return arr[0] + "," + arr[1];
    }

    static void missingNumber(int[] intArray) {
        int x = 1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == x) {
                x++;
            } else {
                break;
            }
        }
        System.out.println(x);
    }

    static int[] twoSum(int[] nums, int target) {
        int[][] r = new int[nums.length][2];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException();
    }


    static int searchInArray(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == valueToSearch) {
                return i;
            }
        }
        return -1;
    }
}
