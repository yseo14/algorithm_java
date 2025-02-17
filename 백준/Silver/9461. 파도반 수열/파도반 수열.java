import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static long[] dp = new long[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            for (int j = 3; j <= n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
