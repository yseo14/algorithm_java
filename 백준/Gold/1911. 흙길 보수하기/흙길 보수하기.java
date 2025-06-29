import java.io.*;
import java.util.*;

public class Main {
    static int n, l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        PriorityQueue<Water> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Water(start, end));
        }

        int ans = 0;
        int checked = 0;

        while (!pq.isEmpty()) {
            Water curr = pq.poll();
            int start = curr.start;
            int end = curr.end;

            if (start <= checked) {
                start = checked;
            }
            while (end > start) {
                start += l;
                ans++;
            }
            checked = start;
        }

        System.out.println(ans);
    }

    public static class Water implements Comparable<Water> {
        int start;
        int end;

        Water(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Water water) {
            return Integer.compare(this.start, water.start);
        }
    }
}
