package dsa.bitwiseoperations;

public class FindNthBitOfANumber {
    public static void main (String [] args) {
        int n = 7;
        int i = 1;

        int m = 11;
        int j = 3;

        int a = 8;
        int b = 4;

        System.out.println(findIthBit(n, i));
        System.out.println(setIthBit(m, j));
        System.out.println(resetIthBit(a, b));
    }

    private static int findIthBit(int n, int i) {
        return ((n >> i - 1) & 1) == 1 ? 1 : 0;
    }

    private static int setIthBit(int m, int j) {
        return m | (1 << j-1);
    }

    private static int resetIthBit(int a, int b) {
        return a & (~(1 << b-1));
    }
}
