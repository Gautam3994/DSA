package dsa.bitwiseoperations;

public class LeftMostSetBitUsingBinarySearch {
    public static void main (String [] args) {
        int num = 10;
        System.out.println(binarySearchSolution(num));
    }

    private static int binarySearchSolution (int num) {
        if (num == 0) return 0;
        int pos = 0;
        if (num >> 16 != 0) {
            pos +=16;
            num = num >> 16;
        }
        if (num >> 8 != 0) {
            pos +=8;
            num = num >> 8;
        }
        if (num >> 4 != 0) {
            pos +=4;
            num = num >> 4;
        }
        if (num >> 2 != 0) {
            pos +=2;
            num = num >> 2;
        }
        if (num >> 1 != 0) {
            pos +=1;
            num = num >> 1;
        }
        return num << pos;
    }

}
