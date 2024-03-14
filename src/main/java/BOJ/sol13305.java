package BOJ;

import java.io.*;
import java.util.*;

public class sol13305 {

    public static int N;
    public static long cost;
    public static long MIN;
    public static long[] road;
    public static long[] oil;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        road = new long[N - 1];
        oil = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] =  Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oil.length; i++) {
            oil[i] =  Long.parseLong(st.nextToken());
        }

        MIN = oil[0];

        for (int i = 0; i < N-1; i++) {
            MIN = Math.min(MIN,oil[i]);
            cost+=MIN*road[i];
        }

        System.out.println(cost);

    }
}
