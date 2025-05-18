package dsa.bitwiseoperations;

public class FindUniqueOnlyOneUniqueOthersKTimes {

    public static void main (String [] args) {
        int [] arr = {2,2,10,7,8,7,8};
        System.out.println(bruteForceSolution(arr, 2));
    }

    /**
     * int unique = 0;
     *         // looping through all 31 bits
     *         for (int i=0; i<32; i++) {
     *             int sum = 0;
     *             // looping through all numbers
     *             for (int n: arr) {
     *                 // finding count of bits in each position
     *                 // we will get count if we do right shift
     *                 // we will get value of bit if we do left shift of 1
     *                 sum += (n >> i) & 1;
     *             }
     *             // we do modulo to find if count if a multiple of k
     *             if(sum % k != 0) {
     *                 // after that we set values each unique bit position for the unique number
     *                 // (sum % k) << i moves it back to its original position
     *                 // this is why we loop through bits first instead of num as we are using it here also
     *                 unique |= sum % k << i;
     *             }
     *         }
     *         return unique;
     * @param arr
     * @param k
     * @return
     */
    private static int bruteForceSolution(int [] arr, int k) {
        int unique = 0;
        for (int i=0; i<32; i++) {
            int sum = 0;
            for (int n: arr) {
                sum += (n >> i) & 1;
            }
            if(sum % k != 0) {
                unique |= sum % k << i;
            }
        }
        return unique;
    }
}
