package BOJ;

import java.io.*;
import java.util.*;

public class sol4179 {
    static int R, C;
    static String[][] map;
    static int[][] fireTime;
    static int result = Integer.MAX_VALUE;
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

        map = new String[R][C];
        fireTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            String[] arr = str.split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = arr[j];
                if (arr[j].equals("#")) {
                    fireTime[i][j] = -1;
                } else if (arr[j].equals("J")) {
                    jihoon = new Point(i, j, 1);
                    jihoonQ.add(jihoon);
                } else if (arr[j].equals("F")) {
                    fireTime[i][j] = 1;
                    fire = new Point(i, j, 0);
                    fireQ.add(fire);
                }
            }
        }

        bfsFire();
        bfsJihoon();

        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    public static void bfsJihoon() {

        while (!jihoonQ.isEmpty()) {
            Point curr = jihoonQ.poll();
            if (curr.x == 0 || curr.y == 0 || curr.x == R - 1 || curr.y == C - 1) {
                isPossible = true;
                result = Math.min(result, curr.time);
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (fireTime[nx][ny] != -1 && fireTime[nx][ny] > curr.time + 1) {
                        jihoonQ.add(new Point(nx, ny, curr.time + 1));
                    }
                }
            }
        }
    }

    public static void bfsFire() {
        while (!fireQ.isEmpty()) {
            Point curr = fireQ.poll();
            int currTime = fireTime[curr.x][curr.y];
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (fireTime[nx][ny] == 0) {
                        fireQ.add(new Point(nx, ny, 0));
                        fireTime[nx][ny] = currTime + 1;
                    }
                }
            }
        }
    }

    public static class Point {
        int x, y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
