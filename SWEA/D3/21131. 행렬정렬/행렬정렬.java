import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[] row1 = new int[n + 1];  // 1-based
            int[] col1 = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (i == 1) row1[j] = val;
                    if (j == 1) col1[i] = val;
                }
            }

            boolean flag = true;
            int count = 0;

            for (int i = n; i >= 1; i--) {
                if (flag && row1[i] != i) {
                    count++;
                    flag = !flag;
                } else if (!flag && col1[i] != i) {
                    count++;
                    flag = !flag;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
