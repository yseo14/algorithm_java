package BOJ;

import java.io.*;
import java.util.*;

public class sol1780 {
    static String[][] map;
    static int N;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        count = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
            }
        }

        func(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    public static void func(int r, int c, int size) {
        if (check(r, c, size)) {
            if (map[r][c].equals("-1")) {
                count[0]++;
            }
            if (map[r][c].equals("0")) {
                count[1]++;
            }
            if (map[r][c].equals("1")) {
                count[2]++;
            }
            return;
        }

        int nSize = size / 3;
        for (int i = r; i < r + size; i += nSize) {
            for (int j = c; j < c + size; j += nSize) {
                func(i, j, nSize);
            }
        }
    }

    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!map[r][c].equals(map[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
