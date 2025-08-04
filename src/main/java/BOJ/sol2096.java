package BOJ;

import java.io.*;
import java.util.*;

public class sol2096 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxDp[i][j] = arr[i][j];
                minDp[i][j] = arr[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = arr[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = arr[i][1] + Math.max(maxDp[i - 1][2], Math.max(maxDp[i - 1][0], maxDp[i - 1][1]));
            maxDp[i][2] = arr[i][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);
        }
        int max = Math.max(maxDp[n - 1][2], Math.max(maxDp[n - 1][0], maxDp[n - 1][1]));

        for (int i = 1; i < n; i++) {
            minDp[i][0] = arr[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = arr[i][1] + Math.min(minDp[i - 1][2], Math.min(minDp[i - 1][0], minDp[i - 1][1]));
            minDp[i][2] = arr[i][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }
        int min = Math.min(minDp[n - 1][2], Math.min(minDp[n - 1][0], minDp[n - 1][1]));

        System.out.println(max + " " + min);
    }
}
