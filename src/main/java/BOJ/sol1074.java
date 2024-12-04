package BOJ;

import java.io.*;
import java.util.*;

public class sol1074 {
    static int N, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(func(N, R, C));
    }

    public static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = (int) (Math.pow(2, n) / 2);
        if (r < half && c < half) {
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        } else {
            return 3 * half * half + func(n - 1, r - half, c - half);
        }
    }
}
