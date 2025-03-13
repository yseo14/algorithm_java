package BOJ;

import java.io.*;
import java.util.*;

public class sol16953_bfs {
    static long a, b;
    static int result = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        Queue<Long> q = new LinkedList<>();
        q.add(a * 2);
        q.add(a * 10 + 1);

        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long curr = q.poll();
                if (curr > b) {
                    continue;
                }
                if (curr == b) {
                    System.out.println(result);
                    return;
                }
                q.add(curr * 2);
                q.add(curr * 10 + 1);
            }
        }
        System.out.println(-1);
    }
}
