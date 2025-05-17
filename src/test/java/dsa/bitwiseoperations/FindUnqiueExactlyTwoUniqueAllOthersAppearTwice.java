package dsa.bitwiseoperations;

import java.util.Arrays;

public class FindUnqiueExactlyTwoUniqueAllOthersAppearTwice {

    public static void main (String [] args) {
        int [] arr = {2,2,10,7,8,7,8,6};
        System.out.println(Arrays.toString(bruteForceSolution(arr)));
    }

    /**
     * int xor = 0;
     *         // All number which are present even number of times will be removed
     *         // The result will be the XOR of the two unique numbers (x ^ y)
     *         for (int n: arr) {
     *             xor ^= n;
     *         }
     *         // Find right most set bit of xor so that we can split based on it
     *         // This will give us 4 which 2 power 2 position which is the right most set bit when 10 ^ 6.
     *         int rightMostSetBit = xor & -xor;
     *         // This bit is guaranteed to be different between x and y. Why?
     *         //Because xor = x ^ y, and if a bit is set (1) in xor, it means the corresponding bits in x and y are different.
     *         int first = 0;
     *         int second = 0;
     *         for (int n: arr) {
     *             // We know rightMostSetBit is present in one unique number and not in the other
     *             // for example 10 = (1010) binary & 6 = (0110) binary
     *             // 10 ^ 6 = 1100 which 2 power 2 position and 2 power 3 position bits are different in 10 and 6
     *             // 2 power 2 position is right most set bit and it is available in only one of numbers (XOR)
     *             // So when present in one it shouldnt be available in the another
     *             // So (n & rightMostSetBit) check if the n in th array is set if yes it adds it to the first group
     *             // else to second group by this each group will have its own unique number
     *             if ((n & rightMostSetBit) == 0) {
     *                 first ^= n;
     *             } else {
     *                 second ^=n;
     *             }
     *         }
     *         return new int[]{first, second};
     * @param arr
     * @return
     */
    private static int[] bruteForceSolution(int[] arr) {
        int xor = 0;
        for (int n: arr) {
            xor ^= n;
        }
        int rightMostSetBit = xor & -xor;
        int first = 0;
        int second = 0;
        for (int n: arr) {
            if ((n & rightMostSetBit) == 0) {
                first ^= n;
            } else {
                second ^=n;
            }
        }
        return new int[]{first, second};
    }
}
