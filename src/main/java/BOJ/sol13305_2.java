package BOJ;

import java.io.*;
import java.util.*;

public class sol13305_2 {
    static int n;
    static long[] prices;
    static long[] distances;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        distances = new long[n - 1];
        prices = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = prices[0];
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            answer += minPrice * distances[i];
        }
        System.out.println(answer);
    }
}
