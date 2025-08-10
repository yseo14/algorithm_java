import java.io.*;
import java.util.*;

public class Main {
    static int n;
    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += dp[n][i];
            sum %= MOD;
        }
        System.out.println(sum % MOD);
    }
}
