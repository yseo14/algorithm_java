package BOJ;

import java.io.*;
import java.util.*;

public class sol9095 {
    static int t, n;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        while (t > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
            t--;
        }
    }
}
