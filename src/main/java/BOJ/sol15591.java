package BOJ;

import java.io.*;
import java.util.*;

public class sol15591 {
    static int n, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        ArrayList<Video>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            graph[start].add(new Video(end, usado));
            graph[end].add(new Video(start, usado));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, k, graph));
        }
    }

    public static int bfs(int start, int k, ArrayList<Video>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int count = 0;

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Video next : graph[curr]) {
                if (!visited[next.num] && next.usado >= k) {
                    count++;
                    q.add(next.num);
                    visited[next.num] = true;
                }
            }
        }
        return count;
    }


    public static class Video {
        int num;
        int usado;

        Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }
    }
}
