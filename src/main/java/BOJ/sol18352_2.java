package BOJ;

import java.io.*;
import java.util.*;

public class sol18352_2 {
    static int n, m, k, x;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] cityList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cityList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            cityList[from].add(to);
        }
        int[] result = bfs(x, cityList);
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

    public static int[] bfs(int start, ArrayList<Integer>[] cityList) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer next : cityList[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }

        return dist;
    }
}
