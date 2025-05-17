package dsa.bitwiseoperations;

public class FindUnique {

    /**
     * This solution doesn't handle multiple unique or more than two duplicates
     * **/
    public static void main (String [] args) {
        /**
         * This works as longs the no of duplicates for each number is an even number like 4 times 4 or 6 times 2
         * **/
        int [] arr = {2,3,3,4,2,6,4,2,2,4,4,4,4};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        int unique = 0;
        for(int n: arr) {
            unique ^= n;
        }
        return unique;
    }
}
