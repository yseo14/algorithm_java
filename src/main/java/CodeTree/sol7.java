package CodeTree;

import java.io.*;
import java.util.*;

/**
 * 최고의 33위치
 */
public class sol7 {
    static int[][] arr;
    static int n;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        function(arr);
        System.out.println(result);
    }

    public static void function(int[][] arr) {
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                count(arr, i, j);
            }
        }
    }

    public static void count(int[][] arr, int row, int col) {
        int coin = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (arr[i][j] == 1) coin++;
            }
        }
        result = Math.max(result, coin);
    }
}
