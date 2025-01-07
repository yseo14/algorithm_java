package BOJ;

import java.io.*;
import java.util.*;

public class sol11652 {
    static int n;
    static long[] arr;
    static int maxCnt = 0;
    static long maxVal = Long.MIN_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i - 1] == arr[i]) {
                cnt++;
            } else {
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                    maxVal = arr[i - 1];
                }
                cnt = 1;
            }
        }
        if (cnt > maxCnt) {
            maxVal = arr[n - 1];
        }
        System.out.println(maxVal);

    }
}
