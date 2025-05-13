import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = curr - 1;
                }
                if (i == 1) {
                    next = curr + 1;
                }
                if (i == 2) {
                    next = curr * 2;
                }

                if (next < 0 || next > 100000 || visited[next] != 0) {
                    continue;
                }
                if (next == k) {
                    System.out.println(visited[curr]);
                    return;
                } else {
                    q.add(next);
                    visited[next] = visited[curr] + 1;
                }
            }
        }
    }
}
