import java.io.*;
import java.util.*;

//  정정보다 간선의 개수가 많으므로 크루스칼 알고리즘으로 구현한다.

public class Main {
    static int v, e;
    static long total;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(n1, n2, cost));
        }

        int count = 0; // 간선 개수 세기
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (find(curr.node1) != find(curr.node2)) {
                union(curr.node1, curr.node2);
                total += curr.cost;
                count++;
            }
        }
        System.out.println(total);
    }

    public static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int cost;

        public Edge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return Integer.compare(this.cost, edge.cost);
        }
    }
}
