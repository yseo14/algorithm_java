import java.io.*;
import java.util.*;

public class Main {
    static int n, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        ArrayList<Video>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            graph[from].add(new Video(to, usado));
            graph[to].add(new Video(from, usado));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            System.out.println(solution(start, k, graph));
        }
    }

    public static int solution(int start, int k, ArrayList<Video>[] graph) {
        PriorityQueue<Video> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        visited[start] = true;
        pq.offer(new Video(start, Integer.MAX_VALUE));
        int count = 0;

        while (!pq.isEmpty()) {
            Video curr = pq.poll();

            for (Video next : graph[curr.num]) {
                if (visited[next.num]) {
                    continue;
                }
                int minUsado = Math.min(next.usado, curr.usado);
                if (minUsado >= k) {
                    count++;
                    pq.offer(new Video(next.num, minUsado));
                }
                visited[next.num] = true;
            }
        }

        return count;
    }

    static class Video implements Comparable<Video> {
        int num;
        int usado;

        Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }

        @Override
        public int compareTo(Video video) {
            return Integer.compare(video.usado, this.usado);
        }
    }
}
