import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Barn>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());
            graph[from].add(new Barn(to, cow));
            graph[to].add(new Barn(from, cow));
        }
        int[] result = dijkstra(1);
        System.out.println(result[n]);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Barn> pq = new PriorityQueue<>();
        pq.offer(new Barn(start, 0));

        while (!pq.isEmpty()) {
            Barn curr = pq.poll();
            if (visited[curr.num]) {
                continue;
            }
            visited[curr.num] = true;
            for (Barn next : graph[curr.num]) {
                if (dist[next.num] > dist[curr.num] + next.cow) {
                    dist[next.num] = dist[curr.num] + next.cow;
                    pq.offer(new Barn(next.num, dist[next.num]));
                }
            }
        }
        return dist;
    }


    public static class Barn implements Comparable<Barn> {
        int num;
        int cow;

        Barn(int num, int cow) {
            this.num = num;
            this.cow = cow;
        }

        @Override
        public int compareTo(Barn barn) {
            return Integer.compare(this.cow, barn.cow);
        }
    }
}
