import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1] + val;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = sum[x2][y2] - sum[x1 - 1][y2]
                    - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
