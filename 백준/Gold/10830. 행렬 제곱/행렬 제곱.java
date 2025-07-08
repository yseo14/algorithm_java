import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = powMatrix(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] powMatrix(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }
        int[][] temp = powMatrix(matrix, exp / 2);
        if (exp % 2 == 1) {
            return multipleMatrix(multipleMatrix(temp, temp), matrix);
        }
        return multipleMatrix(temp, temp);
    }

    public static int[][] multipleMatrix(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
