package BOJ;

import java.io.*;
import java.util.*;

public class sol1927 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}
