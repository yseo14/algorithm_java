package BOJ;

import java.io.*;
import java.util.*;

public class sol11724_2 {
    static int n, m;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        boolean[] visited = new boolean[n + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i, visited);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.add(next);
            }
        }
    }
}
