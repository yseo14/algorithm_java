package BOJ;

import java.io.*;
import java.util.*;

public class sol2098_2 {
    static int n;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 32_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cost = new int[n][n];
        dp = new int[1 << n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(tsp(1, 0));
    }

    public static int tsp(int visited, int curr) {
        if (visited == (1 << n) - 1) {
            if (cost[curr][0] == 0) {
                return INF;
            }
            return cost[curr][0];
        }

        if (dp[visited][curr] != -1) {
            return dp[visited][curr];
        }

        dp[visited][curr] = INF;

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0 && cost[curr][next] != 0) {
                int newVisited = visited | (1 << next);
                int temp = cost[curr][next] + tsp(newVisited, next);
                dp[visited][curr] = Math.min(temp, dp[visited][curr]);
            }
        }

        return dp[visited][curr];
    }
}
