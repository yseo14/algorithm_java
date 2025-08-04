package BOJ;

import java.io.*;
import java.util.*;

public class sol2012 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] =  Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += Math.abs(i - arr[i]);
        }

        System.out.println(ans);
    }
}
