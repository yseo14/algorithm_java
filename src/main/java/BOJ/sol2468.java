package BOJ;

import java.io.*;
import java.util.*;

public class sol2468 {
    static int result = 1;
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        for (int h = 1; h <= max; h++) {
            visited = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if ((newX >= 0 && newX < n) && (newY >= 0 && newY < n) && !visited[newX][newY] && map[newX][newY] > h) {
                dfs(newX, newY, h);
            }
        }
    }
}
