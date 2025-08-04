package BOJ;

import java.io.*;
import java.util.*;

public class sol21921_2 {
    static int n, x;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < x; i++) {
            max += arr[i];
        }
        int maxCnt = 1;

        int sum = max;
        for (int i = 1; i <= n - x; i++) {
            sum = sum - arr[i - 1] + arr[i + x - 1];
            if (sum > max) {
                max = sum;
                maxCnt = 1;
            } else if (max == sum) {
                maxCnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCnt);
    }
}
