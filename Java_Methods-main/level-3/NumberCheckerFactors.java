import java.util.Arrays;

public class NumberCheckerFactors {
    public static int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max) max = f;
        }
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static int productOfCubesOfFactors(int[] factors) {
        int prod = 1;
        for (int f : factors) prod *= Math.pow(f, 3);
        return prod;
    }

    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum > num;
    }

    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum < num;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static boolean isStrong(int num) {
        int sum = 0;
        int n = num;
        while (n > 0) {
            sum += factorial(n % 10);
            n /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        int num = 12;
        int[] factors = getFactors(num);
        System.out.println("Number: " + num);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + greatestFactor(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Product of cubes of factors: " + productOfCubesOfFactors(factors));
        System.out.println("Is Perfect: " + isPerfect(num));
        System.out.println("Is Abundant: " + isAbundant(num));
        System.out.println("Is Deficient: " + isDeficient(num));
        System.out.println("Is Strong: " + isStrong(num));
    }
}
