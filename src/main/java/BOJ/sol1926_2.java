package BOJ;

import java.io.*;
import java.util.*;


public class sol1926_2 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    max = Math.max(bfs(new Coord(i, j)), max);
                    count++;
                }

            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static int bfs(Coord start) {
        Queue<Coord> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        int size = 0;

        while (!q.isEmpty()) {
            Coord curr = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                q.add(new Coord(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return size;
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
