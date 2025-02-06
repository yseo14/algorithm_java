import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        backtracking(0, 0, 1);
        System.out.println(max);
    }

    public static void backtracking(int x, int y, int len) {
        visited[map[x][y] - 'A'] = true;
        max = Math.max(len, max);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= r || nx < 0 || ny >= c || ny < 0) {
                continue;
            }
            if (!visited[map[nx][ny] - 'A']) {
                backtracking(nx, ny, len + 1);
                visited[map[nx][ny] - 'A'] = false;
            }
        }
    }
}
