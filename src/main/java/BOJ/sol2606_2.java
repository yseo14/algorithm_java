package BOJ;

import java.io.*;
import java.util.*;


public class sol2606_2 {

    static int n;
    static int m;
    static int x,y;
    static int[][] map;
    static boolean[] visited;

    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }
        cnt = 0;
        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int start) {
        visited[start] = true;
        cnt++;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
