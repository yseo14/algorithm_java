package BOJ;

import java.io.*;
import java.util.*;

public class sol2631_4 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = Collections.binarySearch(list, arr[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(idx, arr[i]);
            }
        }

        System.out.println(n - list.size());

    }
}