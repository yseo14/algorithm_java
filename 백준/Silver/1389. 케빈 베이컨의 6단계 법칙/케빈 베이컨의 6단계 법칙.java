import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 1; i <= n; i++) {
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] step = new int[n + 1];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : map[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    step[next] = step[curr] + 1;
                    q.add(next);
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += step[i];
        }
        return sum;
    }
}
