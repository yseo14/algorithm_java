import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        System.out.println(func(n, k));
    }

    public static int func(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            dp[n][k] = 1;
            return 1;
        }

        dp[n][k] = func(n - 1, k - 1) % 10007 + func(n - 1, k) % 10007;
        return dp[n][k] % 10007;
    }
}
