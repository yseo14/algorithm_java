package BOJ;

import java.io.*;
import java.util.*;

public class sol5557 {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n + 1][21];
        dp[1][nums[1]] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) { //  i-1번째까지 수를 이용해서 j를 만들 수 있는 경우가 존재하면
                    int plus = j + nums[i];
                    int minus = j - nums[i];
                    if (plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >= 0) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }

            }
        }
        System.out.println(dp[n - 1][nums[n]]);
    }
}
