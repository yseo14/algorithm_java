
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;

    //Java는 int형 배열에 초기값으로 0이 들어간다.
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int idx = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                // x-1, x+1, 2*x 세가지 연산을 위한 반복문
                if (i == 0) {
                    next = idx - 1;
                } else if (i == 1) {
                    next = idx + 1;
                } else {
                    next = idx * 2;
                }
                if (next == K) {
                    System.out.println(visited[idx]);
                    return;
                }

                if ( next >= 0 && next < visited.length&&visited[next] == 0 ) {
                    q.add(next);
                    visited[next] = visited[idx] + 1;
                }
            }

        }

    }
}
