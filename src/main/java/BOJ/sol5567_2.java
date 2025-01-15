package BOJ;

import java.io.*;
import java.util.*;

public class sol5567_2 {
    static int n, m;
    static boolean[] invited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        invited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dfs(0, 1);

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (invited[i]) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(int depth, int friend) {
        if (depth == 2) {
            return;
        }
        for (int i : graph.get(friend)) {
            invited[i] = true;
            dfs(depth + 1, i);
        }
    }
}
