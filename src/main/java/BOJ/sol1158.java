package BOJ;

import java.util.*;
import java.io.*;


public class sol1158 {

    private static int N;
    private static int K;
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        sb.append('<');

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            if (q.size() == 1) {
                sb.append(q.poll()).append(">");
            } else {
                sb.append(q.poll()).append(", ");
            }
        }
        System.out.println(sb);
    }
}
