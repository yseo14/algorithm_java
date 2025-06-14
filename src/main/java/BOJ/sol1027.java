package BOJ;

import java.io.*;
import java.util.*;

public class sol1027 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, check(i));
        }

        System.out.println(max);
    }

    public static int check(int curr) {
        int count = 0;
        double tmp = 0;
        // 왼쪽
        for (int i = curr - 1; i >= 0; i--) {
            double incline = (double) (arr[curr] - arr[i]) / (curr - i);
            if (i == curr - 1 || incline < tmp) {
                tmp = incline;
                count++;
            }
        }

        // 오른쪽
        for (int i = curr + 1; i < n; i++) {
            double incline = (double) (arr[i] - arr[curr]) / (i - curr);
            if (i == curr + 1 || incline > tmp) {
                tmp = incline;
                count++;
            }
        }

        return count;
    }
}
