package BOJ;

import java.io.*;
import java.util.*;

public class sol2212 {
    static int n, k;
    static int[] sensor;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        if (n <= k) {
            System.out.println(0);
            return;
        }
        sensor = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(diff);

        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
