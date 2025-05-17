package dsa.bitwiseoperations;

public class FindRightMostSetBit{
    public static void main (String [] args) {
        int n = 184;
        System.out.println(bruteForceSolution(n));
        System.out.println(optimisedSolution(n));
    }

    private static int bruteForceSolution(int n) {
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                System.out.println(n & 1 << i);
                System.out.println(i);
                return n & 1 << i;
            }
        }
        return 0;
    }

    private static int optimisedSolution(int n) {
        return n & -n;
    }


}
