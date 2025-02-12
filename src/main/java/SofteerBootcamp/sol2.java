package SofteerBootcamp;

import java.io.*;
import java.util.*;

public class sol2 {
    static ArrayList<ArrayList<Next>> map;
    static boolean[] visited;
    static int n;
    static int dist = 0;
    static int resultDist = Integer.MIN_VALUE;
    static int resultStart = 0;
    static int resultEnd = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map  = new ArrayList<>(n +1);
        visited = new boolean[n + 1];
        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map.get(from).add(new Next(to, dist));
        }
        for (int i = 1; i < n + 1; i++) {
            dfs(map.get(1).get(1).room, 0, map.get(1).get(1).room);
        }
        System.out.println(resultDist);
        System.out.println(resultStart);
        System.out.println(resultEnd);
    }

    public static void dfs(int from, int sum, int start) {
        if (sum > resultDist && start < from) {
            resultDist = sum;
            resultEnd = from;
            resultStart = start;
            return;
        }
        visited[from] = true;
        for(Next n: map.get(from)){
            if(!visited[n.room]){
                visited[n.room] = true;
                sum += n.dist;
                dfs(n.room, sum, start);
            }
        }
    }

    public static class Next {
        int room;
        int dist;

        public Next(int room, int dist) {
            this.room = room;
            this.dist = dist;
        }
    }
}
