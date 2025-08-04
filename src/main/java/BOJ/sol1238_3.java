package BOJ;

import java.io.*;
import java.util.*;

public class sol1238_3 {
    static int n, m, x;
    static ArrayList<City>[] graph;
    static int[] totalTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        totalTime = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new City(to, dist));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            totalTime[i] = dijkstra(i, x) + dijkstra(x, i);
            max = Math.max(max, totalTime[i]);
        }

        System.out.println(max);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (visited[curr.num]) {
                continue;
            }
            visited[curr.num] = true;
            for (City next : graph[curr.num]) {
                if (time[next.num] > time[curr.num] + next.time) {
                    time[next.num] = time[curr.num] + next.time;
                    pq.add(new City(next.num, time[next.num]));
                }
            }
        }

        return time[end];
    }

    public static class City implements Comparable<City> {
        int num;
        int time;

        public City(int num, int time) {
            this.num = num;
            this.time = time;
        }

        public int compareTo(City city) {
            return Integer.compare(this.time, city.time);
        }
    }
}
