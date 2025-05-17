package dsa.bitwiseoperations;

public class FindUniqueOnlyOneUniqueOthersThreeTimes {
    public static void main (String [] args) {
        int [] arr = {2,2,3,2,7,7,8,7,8,8};
        System.out.println(findUniqueThreeTimes(arr));
        System.out.println(optimisedSolution(arr));
    }

    /**
     * Brute force approach
     * private static int findUniqueThreeTimes(int[] arr) {
     *         int result = 0;
     *         // Looping through all the bits
     *         for (int i=0; i<32; i++) {
     *             int sum = 0;
     *             // Storing the sum of each bit position
     *             for (int n: arr) {
     *                 // moving position 0 to 31 and & n >> i moves everything to LSB and & 1(0000..1) is used to find the set bit
     *                 // value of that particular position
     *                 sum += n >> i & 1;
     *             }
     *             if ( sum % 3 != 0) {
     * //                System.out.println(sum % 3);
     *                 // Since every other number is repeated three times those bits sum should be multiple of 3
     *                 // So by modulo 3 we can get the unique number
     *                 // Again left shifted to move the bit back to its original position
     *                 result |= (sum % 3 << i);
     *             }
     *         }
     *         return result;
     *     }
     * @param arr
     * @return
     */
    private static int findUniqueThreeTimes(int[] arr) {
        int result = 0;
        for (int i=0; i<32; i++) {
            int sum = 0;
            for (int n: arr) {
                sum += n >> i & 1;
            }
            if ( sum % 3 != 0) {
//                System.out.println(sum % 3);
                result |= (sum % 3 << i);
            }
        }
        return result;
    }

    /**
     * Optimised Solution
     *  Bitwise Finite State Machine (FSM) -
     *
     * int ones = 0;
     *         int twos = 0;
     *
     *         for(int n: arr) {
     *             ones = ones ^ n & ~twos; if number is already in once XOR will make it zero & if first time it will
     *                                      make one 1
     *
     *             twos = twos ^ n & ~ones; if number is already in twice XOR will make it zero & if second time entering
     *                                      loop it will make it 1.
     *
     *                                      if it comes for the third time it will make both ones and twos as zero
     *
     *         EACH ITERATION
     *         ones ^ num toggles XOR bits in ones based on num.
     *
     *          & ~twos ensures bits that are already in twos don’t stay in ones.
     *
     *          Same logic goes for updating twos
     *
     *         }
     *         return ones;
     */
    private static int optimisedSolution(int[] arr) {
        int ones = 0;
        int twos = 0;

        for(int n: arr) {
            ones = ones ^ n & ~twos;
            twos = twos ^ n & ~ones;
        }
        return ones;
    }
}
