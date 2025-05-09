package BOJ;

import java.io.*;
import java.util.*;

public class sol1325 {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int count = bfs(i, visited);
            result[i] = count;
            max = Math.max(max, count);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
