package BOJ;

import java.io.*;
import java.util.*;

public class sol1495 {
    static int n, s, m;
    static int[] v;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[0][s] = true;

        for (int i = 1; i <= n; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int curr = q.poll();
                int up = curr + v[i];
                int down = curr - v[i];

                if (up <= m && !visited[i][up]) {
                    q.add(up);
                    visited[i][up] = true;
                }

                if (down >= 0 && !visited[i][down]) {
                    q.add(down);
                    visited[i][down] = true;
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (visited[n][i]) {
                return i;
            }
        }
        return -1;
    }
}
