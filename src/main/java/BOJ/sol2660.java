package BOJ;

import java.io.*;
import java.util.*;

public class sol2660 {
    static int[] memberDepth;
    static int n;
    static int[][] graph;
    static int INF = 51;
    static int score;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        memberDepth = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == -1 && to == -1) {
                break;
            }
            graph[to][from] = 1;
            graph[from][to] = 1;
        }


        floyd();

        for (int i = 1; i <= n; i++) {
            memberDepth[i] = findMax(graph[i]);
        }

        score = findMin(memberDepth);
        System.out.print(score + " ");
        for (int i = 1; i <= n; i++) {
            if (memberDepth[i] == score) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 1; i <= n; i++) {
            if (memberDepth[i] == score) {
                System.out.print(i + " ");
            }
        }
    }

    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        graph[i][j] = 0;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static int findMax(int[] arr) {
        int max = -1;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = 100;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
