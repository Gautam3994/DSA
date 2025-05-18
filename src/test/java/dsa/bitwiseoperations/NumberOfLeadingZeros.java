package dsa.bitwiseoperations;

public class NumberOfLeadingZeros {

    public static void main (String [] args) {
        int num = 8;
        System.out.println(bruteForceSolutionNumber1(num));
        System.out.println(bruteForceSolutionNumber2(num));
    }

    private static int bruteForceSolutionNumber1(int num) {
        // reverse looping the bits
        int pos = 0;
        while(num!=0) {
            pos++;
            num >>>=1;
        }
        return pos;
    }

    /**
     * We are using log formula to convert to base e to base 2 and find its
     * @param num
     * @return
     */
    private static int bruteForceSolutionNumber2(int num) {
        int highest = highestOneBit(num);
        return (int) (Math.log(highest) / Math.log(2)) +1 ;
    }

    /**
     * same as left most set bit
     * @param num
     * @return
     */
    private static int highestOneBit(int num) {
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        num = num - (num>>1);
        return num;
    }
}
