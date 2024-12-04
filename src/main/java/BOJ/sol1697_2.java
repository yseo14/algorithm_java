package BOJ;

import java.io.*;
import java.util.*;

/**
 * 큐에 1초만에 갈 수 있는 위치를 넣는다.
 */
public class sol1697_2 {
    static int N, K;
    static Queue<Integer> q = new LinkedList<>();
    static int MIN = 0;
    static int MAX = 100000;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001];
        Arrays.fill(time, -1);

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    public static void bfs() {
        q.add(N);
        time[N] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            int next;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = curr - 1;
                } else if (i == 1) {
                    next = curr + 1;
                } else {
                    next = curr * 2;
                }
                if (next == K) {
                    System.out.println(time[curr] + 1);
                    return;
                }
                if (isRange(next) && time[next] == -1) {
                    q.add(next);
                    time[next] = time[curr] + 1;
                }
            }
        }
    }

    public static boolean isRange(int n) {
        return n >= MIN && n <= MAX;
    }
}
