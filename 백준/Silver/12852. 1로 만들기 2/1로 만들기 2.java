import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }
            min = Math.min(min, dp[i - 1] + 1);
            dp[i] = min;
        }
//        System.out.println(Arrays.toString(dp));
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        sb.append(n + " ");
        while (n > 1) {
            int idx = n - 1;
            int min = dp[idx];
            if (n % 2 == 0) {
                if (dp[n / 2] < min) {
                    idx = n / 2;
                    min = dp[n / 2];
                }
            }

            if (n % 3 == 0) {
                if (dp[n / 3] < min) {
                    idx = n / 3;
                    min = dp[n / 3];
                }
            }
            sb.append(idx + " ");
            n = idx;
        }
        System.out.println(sb);
    }
}
