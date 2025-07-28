import java.io.*;
import java.util.*;

public class Main {
    static int n, e;
    static ArrayList<Node>[] graph;
    private static final int INF = 800001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int route1;
        if (dijkstra(1, first) >= INF || dijkstra(first, second) >= INF || dijkstra(second, n) >= INF) {
            route1 = Integer.MAX_VALUE;
        } else {
            route1 = dijkstra(1, first) + dijkstra(first, second) + dijkstra(second, n);
        }

        int route2;
        if (dijkstra(1, second) >=INF || dijkstra(second, first) >= INF || dijkstra(first, n) >= INF){
            route2 = Integer.MAX_VALUE;
        } else{
            route2 = dijkstra(1, second) + dijkstra(second, first) + dijkstra(first, n);
        }
        if (route1 == Integer.MAX_VALUE && route2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(route1, route2));
        }

    }

    public static int dijkstra(int start, int finish) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.num]) {
                continue;
            }
            visited[curr.num] = true;
            for (Node next : graph[curr.num]) {
                if (dist[next.num] > dist[curr.num] + next.dist) {
                    dist[next.num] = dist[curr.num] + next.dist;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        return dist[finish];
    }

    public static class Node implements Comparable<Node> {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.dist, node.dist);
        }
    }
}
