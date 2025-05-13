package BOJ;

import java.io.*;
import java.util.*;

public class sol1697_3 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int[] nextMoves = {curr - 1, curr + 1, curr * 2};
            for (int nextMove : nextMoves) {

                if (nextMove < 0 || nextMove > 100000 || visited[nextMove] != 0) {
                    continue;
                }

                if (nextMove == k) {
                    System.out.println(visited[curr]);
                    return;
                } else {
                    q.add(nextMove);
                    visited[nextMove] = visited[curr] + 1;
                }
            }
        }
    }
}
