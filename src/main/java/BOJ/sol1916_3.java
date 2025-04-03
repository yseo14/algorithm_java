package BOJ;

import java.io.*;
import java.util.*;

public class sol1916_3 {
    static int n, m;
    static int targetStart, targetEnd;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ArrayList<City>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new City(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        targetStart = Integer.parseInt(st.nextToken());
        targetEnd = Integer.parseInt(st.nextToken());
        int[] result = dijkstra(targetStart, graph);
        System.out.println(result[targetEnd]);
    }

    public static int[] dijkstra(int start, ArrayList<City>[] graph) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (visited[curr.num]) {
                continue;
            }
            visited[curr.num] = true;
            for (City next : graph[curr.num]) {
                if (dist[next.num] > dist[curr.num] + next.cost) {
                    dist[next.num] = dist[curr.num] + next.cost;
                    pq.offer(new City(next.num, dist[next.num]));
                }
            }
        }
        return dist;
    }

    public static class City implements Comparable<City> {
        int num, cost;

        City(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(City city) {
            return Integer.compare(this.cost, city.cost);
        }
    }
}
