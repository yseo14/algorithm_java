package BOJ;

import java.io.*;
import java.util.*;

/**
 * 1. 주어지는 K개의 직사각형만큼 모눈종이를 색칠한다. 2. 0,0 부터 색칠되어있지 않은 부분에서 bfs를 돌린다.
 */

public class sol2583 {
    static int m, n, k;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> q;
    static int count = 0;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        size = new int[10001];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fill(x1, y1, x2, y2);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    size[count] = bfs(i, j);
                    count++;
                }
            }
        }
        Arrays.sort(size, 0, count);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            sb.append(size[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void fill(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = 1;
            }
        }
    }

    public static int bfs(int x, int y) {
        q = new LinkedList<>();
        int sum = 1;
        q.add(new Point(x, y));
        map[x][y] = 1;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    q.add(new Point(nx, ny));
                    map[nx][ny] = 1;
                    sum++;
                }
            }
        }
        return sum;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
