

import java.io.*;
import java.util.*;

public class Main {

    static int v, e, k;
    static List<Node>[] connections;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        connections = new ArrayList[v + 1];
        dist = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            connections[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {   // 노드 및 간선의 연결 정보 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            connections[start].add(new Node(end, value));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.end] < curr.value) continue;

            for (Node node : connections[curr.end]) {
                if (dist[node.end] > curr.value + node.value) {
                    dist[node.end] = curr.value + node.value;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int end, value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
