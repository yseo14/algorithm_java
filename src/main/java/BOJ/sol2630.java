package BOJ;

import java.io.*;
import java.util.*;

public class sol2630 {
    static int white = 0;
    static int blue = 0;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void func(int r, int c, int size) {
        if (check(r, c, size)) {
            if (map[r][c] == 0) {
                white++;
            }
            if (map[r][c] == 1) {
                blue++;
            }
            return;
        }
        int nSize = size / 2;
        func(r, c, nSize);
        func(r, c + nSize, nSize);
        func(r + nSize, c, nSize);
        func(r + nSize, c + nSize, nSize);
    }

    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
