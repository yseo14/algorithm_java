import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] isSelected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        isSelected = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);
        System.out.println(result);
    }

    public static void dfs(int count, int start) {
        if (count == n / 2) {
            cal();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                dfs(count + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

    public static void cal() {
        int sum1 = 0, sum2 = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isSelected[i] && isSelected[j]) {
                    sum1 += arr[i][j] + arr[j][i];
                } else if (!isSelected[i] && !isSelected[j]) {
                    sum2 += arr[i][j] + arr[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(sum1 - sum2));
    }
}
