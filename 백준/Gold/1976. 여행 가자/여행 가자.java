import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static List<Integer> plan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 인접 행렬 입력
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여행 계획 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        plan = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            plan.add(Integer.parseInt(st.nextToken()));
        }

        // 여행 계획의 첫 도시에서 DFS 시작
        dfs(plan.get(0));

        // 모든 도시가 연결되어 있었는지 확인
        for (int city : plan) {
            if (!visited[city]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // DFS: 현재 도시에서 연결된 도시들을 재귀적으로 탐색
    static void dfs(int current) {
        visited[current] = true;

        for (int next = 1; next <= n; next++) {
            if (graph[current][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}
