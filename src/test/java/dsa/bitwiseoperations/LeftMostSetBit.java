package dsa.bitwiseoperations;

import java.util.Arrays;

public class LeftMostSetBit {

    public static void main (String [] args) {
        int num = 8;
        System.out.println(bruteForceSolutionNumber(num));
        System.out.println(optimisedSoultion1(num));
        System.out.println(Integer.toBinaryString(optimisedSoultion1(num)));
    }

    /**
     * if(num == 0) {
     *             return 0;
     *         }
     *
     *         // This series of operations sets all bits to the right of the leftmost set bit.
     *         // It's a way to "fill" bits so that all bits below the highest set bit become 1.
     *         // eg for 8 -> 1 0 0 0 we are setting it has 1 1 1 1
     *         num |= num >> 1;
     *         num |= num >> 2;
     *         num |= num >> 4;
     *         num |= num >> 8;
     *         num |= num >> 16;
     *
     *         // Now that all lower bits are 1s:
     *         //n + 1 becomes a power of 2 (next bit)
     *         //
     *         //e.g., 0111 1111 + 1 = 1000 0000
     *         //
     *         //Shifting right by 1 gets us back to the highest power of 2 ≤ original n
     *         //
     *         //i.e., 1000 0000 >> 1 = 0100 0000 = 64
     *         //
     *         //So, for n = 72, the function returns 64, which is the value of the leftmost set bit.
     *         return (num+1)>> 1;
     *
     * @param num
     * @return
     */
    private static int optimisedSoultion1(int num) {
        if(num == 0) {
            return 0;
        }
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        // we stop at 16 because 16+8+4+2+1 gives 31 bits in java and each time we shift >> that many bits get removed
//        return (num+1)>> 1; // There might some cases where this might fail if it is already a power of 2
        // we use unsigned to prevent undesired results with negative numbers
        return num - (num >>> 1);
    }

    /**
     * // reverse looping the bits
     *         for(int i= 31; i>=0; i--) {
     *             // moving bits to LSB and checking it has set bit i.e 1 value
     *             if((num >> i & 1) != 0) {
     *                 System.out.println("Debug" + i);
     *                 // it has create a mask 1 << i to move 1 to the left most set bit position & with num to find the value
     *                 return num & 1 << i;
     *             }
     *         }
     *         return 0;
     * @param num
     * @return
     */
    private static int bruteForceSolutionNumber(int num) {
        // reverse looping the bits
        for(int i= 31; i>=0; i--) {
            // moving bits to LSB and checking it has set bit i.e 1 value
            if((num >> i & 1) != 0) {
                // it has create a mask 1 << i to move 1 to the left most set bit position & with num to find the value
                return num & 1 << i;
            }
        }
        return 0;
    }



}
