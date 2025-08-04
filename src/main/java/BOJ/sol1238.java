package BOJ;

import java.io.*;
import java.util.*;

public class sol1238 {
    static int n, m, x;
    static ArrayList<City>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[from].add(new City(to, time));
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int totalTime = dijkstra(i, x) + dijkstra(x, i);
            ans = Math.max(totalTime, ans);
        }

        System.out.println(ans);
    }

    public static int dijkstra(int from, int to) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[from] = 0;
        pq.add(new City(from, 0));

        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (visited[curr.to]) {
                continue;
            }
            visited[curr.to] = true;
            for (City next : graph[curr.to]) {
                if (time[next.to] > time[curr.to] + next.time) {
                    time[next.to] = time[curr.to] + next.time;
                    pq.add(new City(next.to, time[next.to]));
                }
            }
        }
        return time[to];
    }

    public static class City implements Comparable<City> {
        int to;
        int time;

        public City(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(City city) {
            return Integer.compare(this.time, city.time);
        }
    }
}
