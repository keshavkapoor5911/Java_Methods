import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = rand.nextInt(10) + 1; // 1-10
            }
        }
        return mat;
    }

    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[i][j] = a[i][j] - b[i][j];
        return res;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int rows = a.length, cols = b[0].length, n = a[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < n; k++)
                    res[i][j] += a[i][k] * b[k][j];
        return res;
    }

    public static int[][] transpose(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] res = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[j][i] = mat[i][j];
        return res;
    }

    public static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }

    public static int determinant3x3(int[][] mat) {
        int a = mat[0][0], b = mat[0][1], c = mat[0][2];
        int d = mat[1][0], e = mat[1][1], f = mat[1][2];
        int g = mat[2][0], h = mat[2][1], i = mat[2][2];
        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
    }

    public static double[][] inverse2x2(int[][] mat) {
        int det = determinant2x2(mat);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = mat[1][1] / (double)det;
        inv[0][1] = -mat[0][1] / (double)det;
        inv[1][0] = -mat[1][0] / (double)det;
        inv[1][1] = mat[0][0] / (double)det;
        return inv;
    }

    public static double[][] inverse3x3(int[][] mat) {
        int det = determinant3x3(mat);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[][] minor = new int[2][2];
                int r = 0;
                for (int m = 0; m < 3; m++) {
                    if (m == i) continue;
                    int c = 0;
                    for (int n = 0; n < 3; n++) {
                        if (n == j) continue;
                        minor[r][c++] = mat[m][n];
                    }
                    r++;
                }
                int sign = ((i + j) % 2 == 0) ? 1 : -1;
                inv[j][i] = sign * determinant2x2(minor) / (double)det;
            }
        }
        return inv;
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) System.out.printf("%8.3f", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns for matrices: ");
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] matA = createRandomMatrix(rows, cols);
        int[][] matB = createRandomMatrix(rows, cols);
        System.out.println("Matrix A:");
        displayMatrix(matA);
        System.out.println("Matrix B:");
        displayMatrix(matB);
        System.out.println("A + B:");
        displayMatrix(add(matA, matB));
        System.out.println("A - B:");
        displayMatrix(subtract(matA, matB));
        if (cols == rows) {
            System.out.println("A * B:");
            displayMatrix(multiply(matA, matB));
        }
        System.out.println("Transpose of A:");
        displayMatrix(transpose(matA));
        if (rows == 2 && cols == 2) {
            System.out.println("Determinant of A: " + determinant2x2(matA));
            double[][] inv = inverse2x2(matA);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayMatrix(inv);
            } else {
                System.out.println("Matrix A is singular (no inverse)");
            }
        }
        if (rows == 3 && cols == 3) {
            System.out.println("Determinant of A: " + determinant3x3(matA));
            double[][] inv = inverse3x3(matA);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayMatrix(inv);
            } else {
                System.out.println("Matrix A is singular (no inverse)");
            }
        }
    }
}
