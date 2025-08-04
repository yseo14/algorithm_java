package BOJ;

import java.io.*;
import java.util.*;

public class sol9465 {
    static int t;
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];
            dp[0][0] = 0;
            dp[1][0] = 0;
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = arr[i][j];
                }
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 2; j++) {
                    int temp = Math.max(dp[0][i - 2], dp[1][i - 2]) + arr[j][i];
                    dp[j][i] = Math.max(temp, (j == 0 ? dp[1][i - 1] : dp[0][i - 1]) + arr[j][i]);
                }
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
