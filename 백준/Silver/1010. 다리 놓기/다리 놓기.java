import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp = new int[30][30];
            System.out.println(factorial(m, n));
        }

    }

    static int factorial(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = factorial(n - 1, r - 1) + factorial(n - 1, r);
    }

}
