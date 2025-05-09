package BOJ;

import java.io.*;
import java.util.*;

public class sol2467 {
    static int n;
    static int[] arr;
    static int resultLeft, resultRight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        int val = Integer.MAX_VALUE;
        while (left < right) {
            int mixed = Math.abs(arr[left] + arr[right]);
            if (mixed < val) {
                val = mixed;
                resultLeft = left;
                resultRight = right;
            } else {
                if (arr[left] + arr[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(arr[resultLeft] + " " + arr[resultRight]);
    }
}
