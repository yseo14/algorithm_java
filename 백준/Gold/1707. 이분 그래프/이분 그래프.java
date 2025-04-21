import java.io.*;
import java.util.*;

public class Main {
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

            boolean result = false;
            for (int i = 1; i <= v; i++) {
                if (colors[i] == 0) {
                    result = isBipartite(i, 1);
                }
                if (!result) {
                    break;
                }
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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
                if (colors[next] == colors[curr]) {
                    return false;
                }
                if (colors[next] == 0) {
                    colors[next] = colors[curr] * -1;
                    q.add(next);
                }
            }
        }
        return true;
    }
}