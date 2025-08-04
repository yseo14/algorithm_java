package BOJ;

import java.io.*;
import java.util.*;

public class sol15787_2 {
    static int n, m;
    static int[] trains;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trains = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            int seatNum = -1;
            if (cmd == 1 || cmd == 2) {
                seatNum = Integer.parseInt(st.nextToken());
            }

            if (cmd == 1) {
                trains[trainNum] |= (1 << seatNum - 1);
            }
            if (cmd == 2) {
                trains[trainNum] &= ~(1 << seatNum - 1);
            }
            if (cmd == 3) {
                trains[trainNum] <<= 1;
                trains[trainNum] &= (1 << 20) - 1;
            }
            if (cmd == 4) {
                trains[trainNum] >>= 1;
                trains[trainNum] &= (1 << 20) - 1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(trains[i]);
        }

        System.out.println(set.size());
    }
}
