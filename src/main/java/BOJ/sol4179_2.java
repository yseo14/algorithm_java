package BOJ;

import java.io.*;
import java.util.*;

public class sol4179_2 {
    static int R, C;
    static char[][] map;
    static int[][] fireTime;
    static int[][] jihoonTime;
    static Point jihoon;
    static Point fire;
    static Queue<Point> fireQ = new LinkedList<>();
    static Queue<Point> jihoonQ = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean isPossible = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        jihoonTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;
                if (map[i][j] == 'J') {
                    if (isEdge(i, j)) {
                        System.out.println(1);
                        return;
                    }
                    jihoonTime[i][j] = 0;
                    jihoon = new Point(i, j);
                    jihoonQ.add(jihoon);
                }
                if (map[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    fire = new Point(i, j);
                    fireQ.add(fire);
                }
            }
        }

        bfsFire();
        bfsJihoon();
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        }

    }

    public static void bfsFire() {
        while (!fireQ.isEmpty()) {
            Point curr = fireQ.poll();
            int currTime = fireTime[curr.x][curr.y];
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isNotRange(nx, ny) || map[nx][ny] == '#' //  범위를 넘어서거나, 벽이거나
                        || fireTime[nx][ny] != -1) {   //   이미 불이 번졌거나
                    continue;
                }
                fireQ.add(new Point(nx, ny));
                fireTime[nx][ny] = currTime + 1;
            }
        }
    }

    public static void bfsJihoon() {
        while (!jihoonQ.isEmpty()) {
            Point curr = jihoonQ.poll();
            if (isEdge(curr.x, curr.y)) {
                System.out.println(jihoonTime[curr.x][curr.y] + 1);
                isPossible = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isNotRange(nx, ny) || map[nx][ny] == '#' || jihoonTime[nx][ny] != -1
                        || (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihoonTime[curr.x][curr.y] + 1)) {
                    continue;
                }
                jihoonTime[nx][ny] = jihoonTime[curr.x][curr.y] + 1;
                jihoonQ.add(new Point(nx, ny));
            }
        }
    }

    public static boolean isNotRange(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEdge(int x, int y) {
        if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
