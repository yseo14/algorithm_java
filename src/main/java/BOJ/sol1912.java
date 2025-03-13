package BOJ;

import java.io.*;
import java.util.*;

public class sol1912 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        dp[0] = 0;
        long max = Long.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(num, dp[i - 1] + num);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
