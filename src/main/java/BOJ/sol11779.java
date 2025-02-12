package BOJ;

import java.io.*;
import java.util.*;

public class sol11779 {
    static int n, m;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startTarget = Integer.parseInt(st.nextToken());
        int endTarget = Integer.parseInt(st.nextToken());

        Node[] result = dijkstra(n, startTarget);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int minCost = result[endTarget].cost;
        bw.write(minCost + "\n");

        int[] route = new int[100001];  //  경로를 저장하기 위한 배열
        int count = 0;
        route[count++] = endTarget; //  목적지의 도시 번호를 저장
        while (endTarget != startTarget) {  //  목적지 도시부터 경로를 추적
            endTarget = result[endTarget].index;
            route[count++] = endTarget;
        }
        bw.write(count + "\n");

        for (int i = count - 1; i >= 0; i--) {
            bw.write(route[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    public static Node[] dijkstra(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Node[] dist = new Node[n + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            dist[i] = new Node(i, INF);
        }
        dist[start] = new Node(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int curr = pq.poll().index;
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            for (Node next : graph[curr]) {
                if (dist[next.index].cost > dist[curr].cost + next.cost) {
                    dist[next.index].cost = dist[curr].cost + next.cost;
                    dist[next.index].index = curr;  //  경유한 도시의 번호로 업데이트
                    pq.offer(new Node(next.index, dist[next.index].cost));
                }
            }
        }
        return dist;
    }

    public static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
}
