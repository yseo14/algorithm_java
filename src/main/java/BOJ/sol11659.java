package BOJ;

import java.io.*;
import java.util.*;

public class sol11659 {
    static int n, m;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sum = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = Integer.parseInt((st.nextToken()));
            } else {
                sum[i] = sum[i - 1] + Integer.parseInt((st.nextToken()));
            }
        }

        while (m > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (i == 1) {
                System.out.println(sum[j - 1]);
            } else {
                System.out.println(sum[j - 1] - sum[i - 2]);
            }
            m--;
        }
    }
}
