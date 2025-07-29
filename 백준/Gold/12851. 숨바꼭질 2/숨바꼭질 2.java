import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] time;
    static int count = 0;
    final static int MAX = 100001;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }
        time = new int[MAX];

        bfs(n);

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        time[start] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (minTime < time[curr]) return;
            int[] nextMoves = {curr - 1, curr + 1, curr * 2};
            for (int next : nextMoves) {
                if (next < 0 || next >= MAX) {
                    continue;
                }
                if (next == k) {
                    minTime = time[curr];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[curr] + 1) {  //  첫 방문이거나, 같은 시간 안에 도달한다면 추가
                    q.add(next);
                    time[next] = time[curr] + 1;
                }
            }
        }
    }
}
