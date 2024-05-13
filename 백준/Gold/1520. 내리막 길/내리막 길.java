
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map, dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(0,0));
//        for (int i = 0; i < m; i++) {
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//        }
    }

    public static int dfs(int x, int y) {

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                continue;
            }

            if (map[newX][newY] < map[x][y]) {
                dp[x][y] += dfs(newX, newY);
            }
//
//            for (int p = 0; p < m; p++) {
//                System.out.println();
//                for (int q = 0; q < n; q++) {
//                    System.out.print(dp[p][q]+" ");
//                }
//            }
//            System.out.println();
        }

        return dp[x][y];
    }


}
