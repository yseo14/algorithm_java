package BOJ;

import java.io.*;
import java.util.*;

/**
 * 인접행렬을 사용한 구현
 */

public class sol2606_3 {

    static int n, m, cnt;
    static int x, y;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        cnt = 0;

        dfs(1);
        bw.write(String.valueOf(cnt - 1));
        bw.close();
    }

    public static void dfs(int start) {
        visited[start] = true;
        cnt++;
        int size = graph.get(start).size();
        for (int i = 0; i < size; i++) {
            int value = graph.get(start).get(i);
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}
