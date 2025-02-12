package BOJ;

import java.io.*;
import java.util.*;

public class sol13549 {
    static int n, k;
    static int[] time = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(time[k] - 1);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr + 1 >= 0 && curr + 1 <= 100000) {  //  앞으로 이동
                if (time[curr + 1] == 0 || time[curr + 1] > time[curr] + 1) {   //  아직 방문한 적 없거나, 방문했지만 시간이 더 오래 걸리는 경우
                    time[curr + 1] = time[curr] + 1;
                    q.add(curr + 1);
                }
            }
            if (curr - 1 >= 0 && curr - 1 <= 100000) {  //  뒤로 이동
                if (time[curr - 1] == 0 || time[curr - 1] > time[curr] + 1) {   //  아직 방문한 적 없거나, 방문했지만 시간이 더 오래 걸리는 경우
                    time[curr - 1] = time[curr] + 1;
                    q.add(curr - 1);
                }
            }
            if (curr * 2 >= 0 && curr * 2 <= 100000) {  //  순간이동
                if (time[curr * 2] == 0 || time[curr * 2] > time[curr]) {   //  아직 방문한 적 없거나, 방문했지만 시간이 더 오래 걸리는 경우
                    time[curr * 2] = time[curr];
                    q.add(curr * 2);
                }
            }
        }
    }
}
