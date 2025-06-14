package BOJ;

import java.io.*;
import java.util.*;

public class sol13144_2 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        boolean[] used = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        long count = 0;
        for (int start = 0; start < n; start++) {
            while (end < n && !used[arr[end]]) {
                used[arr[end]] = true;
                end++;
            }
            count += end - start;
            used[arr[start]] = false;
        }

        System.out.println(count);
    }
}
