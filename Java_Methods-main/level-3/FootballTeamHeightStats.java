import java.util.Random;
import java.util.Arrays;

public class FootballTeamHeightStats {
    public static int[] generateHeights(int size, int min, int max) {
        int[] heights = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(max - min + 1) + min;
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    public static double mean(int[] arr) {
        return sum(arr) / (double) arr.length;
    }

    public static int shortest(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int tallest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11, 150, 250);
        System.out.println("Player heights: " + Arrays.toString(heights));
        System.out.println("Sum of heights: " + sum(heights));
        System.out.printf("Mean height: %.2f\n", mean(heights));
        System.out.println("Shortest height: " + shortest(heights));
        System.out.println("Tallest height: " + tallest(heights));
    }
}
