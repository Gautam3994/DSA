package dsa.bitwiseoperations;

public class OddOrEven {
    public static void main (String [] args) {
        int n = -10;
        System.out.println(oddOrEven(n));
    }

    private static Boolean oddOrEven(int n) {
         return (n & 1) == 1;
    }
}
