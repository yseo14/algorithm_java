package BOJ;

import java.io.*;
import java.util.*;

public class sol15989 {
    static int t, n;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];

        }
        while (t > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
            t--;
        }
    }
}
