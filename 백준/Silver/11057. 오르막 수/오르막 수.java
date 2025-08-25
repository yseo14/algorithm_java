import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < j + 1; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
                dp[i][j] %= 10007;
            }
        }
        for (int i = 0; i < 10; i++) {
            count += (dp[n][i] % 10007);
        }
        System.out.println(count % 10007);
    }
}
