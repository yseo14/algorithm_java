package Softeer;

import java.io.*;
import java.util.*;

public class sol6246 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 0;
    static List<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            points.add(new Point(x, y));
        }
        Point start = points.get(0);
        visited[start.x][start.y] = true;
        dfs(start.x, start.y, 0);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int pointIdx) {
        if (pointIdx == m) {
            result += 1;
            return;
        }
        if (x == points.get(pointIdx).x && y == points.get(pointIdx).y) {
            dfs(x, y, pointIdx + 1);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] != 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, pointIdx);
                visited[nx][ny] = false;
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
