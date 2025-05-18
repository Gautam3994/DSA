package dsa.bitwiseoperations;

public class NumberOfLeadingZerosUsingBinarySearch {

    public static void main (String [] args) {
        int num = 2;
        System.out.println(binarySearchSolution(num));
    }

    private static int binarySearchSolution(int num) {
        int zeros = 1;
        // if whole number is zero return 32 zeros
        if (num == 0) return 32;
        // check if the first 16 bits are zeros - from left to right
        // If yes zeros = zeros + 16
        // Then left shift by 16 so the zeros are  moved out of significance
        // And The set bit(s) are moved forward
        // for 2 (...0010) becomes 0000 0000 0000 0010 -> then zeros due to left shift
        if(num >>> 16 == 0) {
            zeros += 16;
            num <<= 16;
        }
        // check if the first 24 bits are zeros - from left to right
        //  We are doing this to  check if then first 8 bits in  (0000 0000 0000 0010 then 16 zeros) are zeros
        // If yes zeros = zeros + 8
        // Then left shift by 8 so the zeros are moved out of significance
        // now it becomes 0000 0010 - then 24 zeros
        if (num >>> 24 == 0) {
            zeros += 8;
            num <<=8;
        }
        // check if the first 28 bits are zeros - from left to right
        //  We are doing this to  check if then first 4 bits in  (0000 0010 then 24 zeros) are zeros
        // If yes zeros = zeros + 4
        // Then left shift by 4 so the zeros are moved out of significance
        // now it becomes 0010 - then 28 zeros
        if (num >>> 28 == 0) {
            zeros += 4;
            num <<=4;
        }
        // check if the first 30 bits are zeros - from left to right
        //  We are doing this to  check if then first 2 bits in  (0010 then 28 zeros) are zeros
        // If yes zeros = zeros + 2
        // Then left shift by 2 so the zeros are moved out of significance
        // now it becomes 10 - then 30 zeros
        if (num >>> 30 == 0) {
            zeros += 2;
            num <<=2;
        }

        // After for num = 10 then 30 zeros
        // in MSB we have 1 for any other number other than 1
//        if (num >>> 31 == 0) {
//            zeros += 1;
//        }

        // to avoid the above if branch we start with 1 and do this subtraction
         zeros -= (num >>> 31);

        return zeros;

    }
}
