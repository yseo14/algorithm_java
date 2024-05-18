
import java.io.*;
import java.util.*;


public class Main {

    static Integer n;
    static Integer[][] cost;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cost = new Integer[n][3];
        dp = new Integer[n][3];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) dp[i][j] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                if (j == 1) dp[i][j] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                if (j == 2) dp[i][j] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
