package BOJ;

import java.io.*;
import java.util.*;

public class sol1158_2 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        sb.append("<");
        while (!dq.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                dq.addLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst());

            if (!dq.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
