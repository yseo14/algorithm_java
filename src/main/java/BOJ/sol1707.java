package BOJ;

import java.io.*;
import java.util.*;

public class sol1707 {
    static int k;
    static int v, e;
    static ArrayList<Integer>[] graph;
    static int[] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        while (k > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            colors = new int[v + 1];
            graph = new ArrayList[v + 1];
            for (int i = 0; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            boolean result = true;

            for (int i = 1; i <= v; i++) {
                if (colors[i] == 0) {   //  아직 색칠되지 않은 정점이라면 방문하지 않은 것이므로 탐색 시작
                    result = isBipartite(i, 1);
                }
                if (!result) {  //  이분 그래프가 아닌 것이 판명되면 반복문 종료
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
            k--;
        }
    }

    public static boolean isBipartite(int start, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = color;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (colors[next] == colors[curr]) { //  인접한 정점이 현재 정점과 같은 색이라면
                    return false;   //  이분 그래프가 아님
                }
                if (colors[next] == 0) {    //  인접한 정점이 아직 칠해지지 않았다면,
                    colors[next] = colors[curr] * -1;   //  현재 정점과 다른 색으로 색칠
                    q.add(next);
                }
            }
        }
        return true;
    }
}