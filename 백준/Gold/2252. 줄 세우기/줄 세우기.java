import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            arr[to]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr + " ");

            for (int next : graph[curr]) {
                arr[next]--;
                if (arr[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
