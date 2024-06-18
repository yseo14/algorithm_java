
import java.io.*;
import java.util.*;

/**
 * 촌수 계산
 * DFS로 풀이
 */

public class Main {

    static boolean[] visited;
    static List<Integer>[] relation;
    static int result = -1;
    static int n, x, y, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        relation = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            relation[p].add(c);
            relation[c].add(p);
        }

        dfs(x, y, 0);
        System.out.println(result);
    }

    public static void dfs(int start, int end, int cnt) {

        if (start == end) {
            //  값 계산
            result = cnt;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!visited[next]) {
                dfs(next, end, cnt+1);
            }
        }
    }
}
