package BOJ;

import java.io.*;
import java.util.*;

public class sol16401 {
    static int m, n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(1, max));
    }

    public static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (Integer i : arr) {
                count += i / mid;
            }

            if (count >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
