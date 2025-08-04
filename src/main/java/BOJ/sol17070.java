package BOJ;

import java.io.*;
import java.util.*;

public class sol17070 {
    static int n;
    static int[][] map;
    static int[][] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        count = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (map[n][n] == 1) {
            System.out.println(0);
            return;
        }

        count[1][2] = 1;
        bfs();

        System.out.println(count[n][n]);
    }

    public static void bfs() {
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(1, 2, 0));

        while (!q.isEmpty()) {
            Coord curr = q.poll();
            if (curr.position == 0) {   //  현재 상태가 가로 -> 가로, 대각선만 체크
                //  가로 체크
                if (checkNextCoord(curr.r, curr.c + 1)) {
                    addPosition(curr.r, curr.c + 1, q, curr, 0);
                }

                // 대각선 체크
                if ((checkNextCoord(curr.r, curr.c + 1)) && checkNextCoord(curr.r + 1, curr.c + 1)&& checkNextCoord(curr.r + 1, curr.c)) {
                    addPosition(curr.r + 1, curr.c + 1, q, curr, 1);
                }
            }

            if (curr.position == 1) {   //  현재 상태가 대각선 -> 가로, 세로, 대각선 체크
                //  가로 체크
                if (checkNextCoord(curr.r, curr.c + 1)) {
                    addPosition(curr.r, curr.c + 1, q, curr, 0);
                }

                // 대각선 체크
                if ((checkNextCoord(curr.r, curr.c + 1)) && checkNextCoord(curr.r + 1, curr.c + 1)&& checkNextCoord(curr.r + 1, curr.c)) {
                    addPosition(curr.r + 1, curr.c + 1, q, curr, 1);
                }

                //  세로 체크
                if (checkNextCoord(curr.r + 1, curr.c)) {
                    addPosition(curr.r + 1, curr.c, q, curr, 2);
                }
            }

            if (curr.position == 2) {   //  현재 상태가 세로 -> 세로, 대각선 체크
                // 대각선 체크
                if ((checkNextCoord(curr.r, curr.c + 1)) && checkNextCoord(curr.r + 1, curr.c + 1)&& checkNextCoord(curr.r + 1, curr.c)) {
                    addPosition(curr.r + 1, curr.c + 1, q, curr, 1);
                }

                //  세로 체크
                if (checkNextCoord(curr.r + 1, curr.c)) {
                    addPosition(curr.r + 1, curr.c, q, curr, 2);
                }
            }
        }
    }

    private static boolean checkNextCoord(int nr, int nc) {
        return (!isOutOfRange(nr, nc) && map[nr][nc] == 0);
    }

    private static void addPosition(int nr, int nc, Queue<Coord> q, Coord curr, int position) {
        q.add(new Coord(nr, nc, position));
        count[nr][nc] += 1;
    }


    public static boolean isOutOfRange(int r, int c) {
        return (r < 1 || c < 1 || r > n || c > n);
    }

    public static class Coord {
        int r, c;
        int position;   //  0: 가로, 1: 대각선, 2: 세로

        public Coord(int r, int c, int position) {
            this.r = r;
            this.c = c;
            this.position = position;
        }
    }
}
