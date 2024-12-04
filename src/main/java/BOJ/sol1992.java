package BOJ;

import java.io.*;

public class sol1992 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        func(0, 0, N);
        System.out.println(sb.toString());
    }

    public static void func(int r, int c, int size) {
        if (check(r, c, size)) {
            sb.append(map[r][c]);
            return;
        }
        int nSize = size / 2;
        sb.append("(");
        func(r, c, nSize);
        func(r, c + nSize, nSize);
        func(r + nSize, c, nSize);
        func(r + nSize, c + nSize, nSize);
        sb.append(")");
    }

    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != (map[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

}
