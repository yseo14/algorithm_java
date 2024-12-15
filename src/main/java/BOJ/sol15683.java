package BOJ;

import java.io.*;
import java.util.*;

/**
 * 1. 각 cctv의 방향을 설정한다. - 4진법을 활용해서 각 cctv의 방향을 표시 2. 사각지대의 수를 구한다. -
 */

public class sol15683 {

    static int N, M;
    static ArrayList<Point> cctvList = new ArrayList<>();
    static int[][] origin;
    static int[][] after;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                if (origin[i][j] != 0 && origin[i][j] != 6) {   //  cctv 좌표 저장
                    cctvList.add(new Point(i, j));
                }
                if (origin[i][j] == 0) {
                    answer += 1;
                }
            }
        }

        for (int tmp = 0; tmp < powerCal(4, cctvList.size()); tmp++) {
            after = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    after[i][j] = origin[i][j];
                }
            }

            int attempt = tmp;
            for (int i = 0; i < cctvList.size(); i++) {
                int dir = attempt % 4;
                attempt = attempt / 4;

                int x = cctvList.get(i).x;
                int y = cctvList.get(i).y;

                if (origin[x][y] == 1) {
                    update(x, y, dir);
                }
                if (origin[x][y] == 2) {
                    update(x, y, dir);
                    update(x, y, dir + 2);
                }
                if (origin[x][y] == 3) {
                    update(x, y, dir);
                    update(x, y, dir + 1);
                }
                if (origin[x][y] == 4) {
                    update(x, y, dir);
                    update(x, y, dir + 1);
                    update(x, y, dir + 2);
                }
                if (origin[x][y] == 5) {
                    update(x, y, dir);
                    update(x, y, dir + 1);
                    update(x, y, dir + 2);
                    update(x, y, dir + 3);
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (after[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }

    public static void update(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (isOutOfRange(x, y) || after[x][y] == 6) {
                return;
            }
            if (after[x][y] != 0) {
                continue;
            }
            after[x][y] = 7;
        }
    }

    public static int powerCal(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static boolean isOutOfRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return true;
        }
        return false;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
