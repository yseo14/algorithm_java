package BOJ;

import java.io.*;
import java.util.*;

public class sol1967 {
    static int n;
    static ArrayList<Node>[] tree;
    static int max = 0;
    static int node = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, cost));
            tree[to].add(new Node(from, cost));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[node] = true;
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int dist) {
        if (dist > max) {
            max = dist;
            node = start;
        }
        for (Node next : tree[start]) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(next.num, dist + next.cost);
            }
        }
    }

    public static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
