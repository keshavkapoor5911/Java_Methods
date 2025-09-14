import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {
    // Recursive method to find sum of n natural numbers
    public static int recursiveSum(int n) {
        if (n == 1) return 1;
        return n + recursiveSum(n - 1);
    }

    // Formula method to find sum of n natural numbers
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (!isNaturalNumber(n)) {
            System.out.println("Not a natural number. Exiting.");
            return;
        }
        int sumRecursive = recursiveSum(n);
        int sumFormula = formulaSum(n);
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);
        if (sumRecursive == sumFormula) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("Results do not match. Check logic.");
        }
    }
}
