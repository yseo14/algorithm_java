import java.io.*;
import java.util.*;

public class Main {
    static int n, s, m;
    static int[] v;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n + 1][m + 1];

        q.add(s);
        visited[0][s] = true;

        for (int i = 0; i < n; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int curr = q.poll();
                int up = curr + v[i];
                int down = curr - v[i];

                if (up <= m && !visited[i + 1][up]) {
                    q.add(up);
                    visited[i + 1][up] = true;
                }

                if (down >= 0 && !visited[i + 1][down]) {
                    q.add(down);
                    visited[i + 1][down] = true;
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
