package BOJ;

import java.io.*;
import java.util.*;

public class sol2573 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true) {
            int result = countIsland();
            if (result >= 2) {
                break;
            } else if (result == 0) {
                year = 0;
                break;
            }
            melting();
            year++;
        }
        System.out.println(year);
    }

    public static int countIsland() {   //  dfs를 사용해서 섬의 개수를 카운팅
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void melting() {
        Queue<Island> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    q.add(new Island(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Island land = q.poll();
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = land.x + dx[i];
                int ny = land.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    sea++;
                }
            }
            if (map[land.x][land.y] - sea < 0) {
                map[land.x][land.y] = 0;
            }else {
                map[land.x][land.y] -= sea;
            }
        }

    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (!visited[nx][ny] && map[nx][ny] > 0) {
                dfs(nx, ny, visited);
            }
        }
    }

    public static class Island{
        int x, y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
