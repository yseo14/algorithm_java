package BOJ;

import java.io.*;
import java.util.*;

public class sol11054 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }

        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
        }

        int[] result = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            result[i] = dp1[i] + dp2[i] - 1;
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}
