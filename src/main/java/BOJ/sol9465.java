package BOJ;

import java.io.*;
import java.util.*;

public class sol9465 {
    static int t;
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            t--;
        }
    }
}
