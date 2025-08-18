import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reversedGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 학생 수
        m = Integer.parseInt(st.nextToken()); // 도로 수
        x = Integer.parseInt(st.nextToken()); // 파티 위치

        graph = new ArrayList[n + 1];
        reversedGraph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));          // 정방향 그래프
            reversedGraph[to].add(new Node(from, cost));  // 역방향 그래프
        }

        // X → 모든 노드
        int[] fromX = dijkstra(x, graph);
        // 모든 노드 → X (역방향 그래프에서 X → 모든 노드로 해석)
        int[] toX = dijkstra(x, reversedGraph);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int roundTrip = toX[i] + fromX[i];
            result = Math.max(result, roundTrip);
        }

        System.out.println(result);
    }

    public static int[] dijkstra(int start, ArrayList<Node>[] g) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.to]) continue;
            visited[curr.to] = true;

            for (Node next : g[curr.to]) {
                if (distance[next.to] > distance[curr.to] + next.cost) {
                    distance[next.to] = distance[curr.to] + next.cost;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }

        return distance;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
