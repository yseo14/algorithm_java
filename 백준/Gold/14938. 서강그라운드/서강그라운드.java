import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] items;
    static ArrayList<Region>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new Region(to, dist));
            graph[to].add(new Region(from, dist));
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dijkstra(i));
        }
        System.out.println(result);
    }

    public static int dijkstra(int start) {
        PriorityQueue<Region> pq = new PriorityQueue<>();
        pq.add(new Region(start, 0));

        int[] totalDist = new int[n + 1];
        Arrays.fill(totalDist, Integer.MAX_VALUE);
        totalDist[start] = 0;

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Region curr = pq.poll();
            if (visited[curr.to]) {
                continue;
            }
            visited[curr.to] = true;
            for (Region next : graph[curr.to]) {
                if (totalDist[next.to] > totalDist[curr.to] + next.dist) {
                    totalDist[next.to] = totalDist[curr.to] + next.dist;
                    pq.add(new Region(next.to, totalDist[next.to]));
                }
            }
        }

        int itemCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (totalDist[i] <= m) {
                itemCnt += items[i];
            }
        }

        return itemCnt;
    }

    public static class Region implements Comparable<Region> {
        int to;
        int dist;

        public Region(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Region region) {
            return Integer.compare(this.dist, region.dist);
        }
    }
}
