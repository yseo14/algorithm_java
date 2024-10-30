package BOJ;

import java.io.*;
import java.util.*;

public class sol13300 {
    static int N, K, S, Y;
    static int[][] rooms;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rooms = new int[7][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            rooms[Y][S]++;
        }

        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                if (rooms[i][j] % K == 0) {
                    count += rooms[i][j] / K;
                }else {
                    count += rooms[i][j] / K + 1;
                }
            }
        }

        System.out.println(count);
    }
}
