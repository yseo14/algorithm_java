package BOJ;

import java.io.*;
import java.util.*;

public class sol2668 {
    static int n;
    static int[] arr;
    static List<Integer> result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1]; // 매 DFS마다 visited 초기화
            dfs(i, i);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static void dfs(int start, int target) {
        if (!visited[start]) {
            visited[start] = true;
            int next = arr[start];
            dfs(next, target);
            visited[start] = false;
        } else if (start == target) {
            result.add(target);
        }
    }
}
