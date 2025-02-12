package BOJ;

import java.io.*;
import java.util.*;

public class sol11053 {
    static int n;
    static int[] seq;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {   //  현재 구해야하는 seq까지만 탐색하면 됨
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(max);
    }
}
