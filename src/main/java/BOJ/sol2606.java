package BOJ;

import java.io.*;
import java.util.*;

public class sol2606 {
    public static int N;
    public static int V;
    public static int count = 0;
    public static int[][] arr;
    public static boolean[] visit;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1]; 
        visit = new boolean[N + 1];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }
        dfs(1);
        System.out.println(count-1);
    }

    public static void dfs(int num) {
        visit[num] = true;
        count++;

        for (int i = 1; i <= N; i++) {
            if (arr[num][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
