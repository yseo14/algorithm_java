package BOJ;

import java.io.*;
import java.util.*;

public class sol31963 {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long prev = arr[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            while (prev > arr[i]) {
                arr[i] *= 2;
                count++;
            }
            prev = arr[i];
        }
        System.out.println(count);
    }
}
