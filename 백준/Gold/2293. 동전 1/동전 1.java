import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] coins;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        Arrays.sort(coins);
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= k; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i][j - coins[i]] != 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }


        System.out.println(dp[n - 1][k]);
    }
}
