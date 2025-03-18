import java.io.*;
import java.util.*;

public class Main {
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
            int cnt = countIsland();
            if (cnt >= 2) {
                break;
            } else if (cnt == 0) {
                year = 0;
                break;
            }
            meltIceBerg();
            year++;
        }
        System.out.println(year);
    }

    public static void meltIceBerg() {
        Queue<IceBerg> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    q.add(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            IceBerg ice = q.poll();
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    sea++;
                }
            }
            if (map[ice.x][ice.y] - sea < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= sea;
            }
        }
    }

    public static int countIsland() {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
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

    static class IceBerg {
        int x, y;

        IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
