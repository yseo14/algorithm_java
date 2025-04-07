import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, x;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<City>[] cityList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cityList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            cityList[from].add(new City(to, 1));
        }
        int[] result = dijkstra(x, cityList);
        boolean isExist = false;
        for (int i = 1; i < n + 1; i++) {
            if (result[i] == k) {
                isExist = true;
                bw.write(i+"\n");
            }
        }
        if (!isExist) {
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int[] dijkstra(int start, ArrayList<City>[] cityList) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<City> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new City(start, 0));

        while (!q.isEmpty()) {
            City curr = q.poll();
            if (visited[curr.num]) {
                continue;
            }
            visited[curr.num] = true;
            for (City next : cityList[curr.num]) {
                if (dist[next.num] > dist[curr.num] + 1) {
                    dist[next.num] = dist[curr.num] + 1;
                    q.offer(new City(next.num, dist[next.num]));
                }
            }
        }
        return dist;
    }

    public static class City implements Comparable<City>{
        int num, cost;

        City(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(City city) {
            return Integer.compare(this.cost, city.cost);
        }
    }
}
