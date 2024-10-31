package Softeer;

import java.io.*;
import java.util.*;

public class sol363 {
    static int n;
    static int m;
    static List<List<Integer>> graph;
    static List<List<Integer>> rGraph;
    static int S;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        rGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            rGraph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        dfs(S, T, s1, graph, new boolean[n + 1]);
        dfs(T, -1, s2, rGraph, new boolean[n + 1]);
        s1.retainAll(s2);

        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        dfs(T, S, s3, graph, new boolean[n + 1]);
        dfs(S, -1, s4, rGraph, new boolean[n + 1]);
        s3.retainAll(s4);

        s1.retainAll(s3);

        int result = s1.size();
        if (s1.contains(S)) {
            result--;
        }
        if (s1.contains(T)) {
            result--;
        }
        System.out.println(result);

    }

    public static void dfs(int node, int target, Set<Integer> set, List<List<Integer>> graph, boolean[] visited) {
        if (target != -1 && node == target) {
            return;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            set.add(next);
            dfs(next, target, set, graph, visited);
        }

    }
}
