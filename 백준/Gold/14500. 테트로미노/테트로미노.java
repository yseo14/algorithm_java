import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int result = 0;
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

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, visited, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(result);

    }

    public static void dfs(int x, int y, int cnt, boolean[][] visited, int sum) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, visited, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    public static void check(int x, int y) {
        if (x + 2 < n && y + 1 < m) {   //  ㅏ
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);
        }

        if (x + 1 < n && y + 2 < m) {   //  ㅜ
            result = Math.max(result, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);
        }

        if (x + 2 < n && y - 1 >= 0) {   //  ㅓ
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);
        }

        if (x - 1 >= 0 && y + 2 < m) {   //  ㅗ
            result = Math.max(result, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
        }
    }
}
