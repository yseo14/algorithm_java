import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        int[] count = new int[f + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        count[s] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == g) {
                System.out.println(count[curr]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next;
                if (i == 0) {
                    next = curr + u;
                } else {
                    next = curr - d;
                }
                if (next > f || next < 1) {
                    continue;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count[next] = count[curr] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }
}
