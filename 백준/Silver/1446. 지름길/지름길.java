import java.io.*;
import java.util.*;

public class Main {
    static int n, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        List<ShortCut> shortCuts = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end - start < dist || end > d) {
                continue;
            }
            shortCuts.add(new ShortCut(start, end, dist));
        }
        Collections.sort(shortCuts);

        int[] dp = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (ShortCut sc : shortCuts) {
                if (sc.start == i) {
                    if (dp[sc.end] > dp[i] + sc.dist) {
                        dp[sc.end] = dp[i] + sc.dist;
                    }
                }
            }
        }
        System.out.println(dp[d]);
    }

    public static class ShortCut implements Comparable<ShortCut> {
        int start, end, dist;

        ShortCut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(ShortCut o) {
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            } else if (this.end != o.end) {
                return Integer.compare(this.end, o.end);
            } else {
                return Integer.compare(this.dist, o.dist);
            }
        }
    }
}
