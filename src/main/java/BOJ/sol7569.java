package BOJ;

import java.io.*;
import java.util.*;

public class sol7569 {
    static int m, n, h;
    static int[][][] box;
    static int[][][] time;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> tomato;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        time = new int[h][n][m];
        tomato = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) tomato.add(new Point(k, j, i));
                    if (box[i][j][k] == 0) time[i][j][k] = -1;
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (time[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, time[i][j][k]);
                }
            }
        }
        System.out.println(result);


    }

    public static void bfs() {
        while (!tomato.isEmpty()) {
            Point p = tomato.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                if ((nx >= 0 && nx < m) && (ny >= 0 && ny < n) && (nz >= 0 && nz < h)) {
                    if (box[nz][ny][nx] == 0 && time[nz][ny][nx] == -1) {
                        tomato.add(new Point(nx, ny, nz));
                        time[nz][ny][nx] = time[p.z][p.y][p.x] + 1;
                    }
                }
            }
        }
    }


    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
