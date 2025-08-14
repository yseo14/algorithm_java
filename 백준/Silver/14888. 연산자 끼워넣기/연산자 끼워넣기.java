import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] cmd;
    static int minResult = Integer.MAX_VALUE;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        cmd = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void dfs(int currIdx, int total) {   //  total = 1 시작
        if (currIdx == n) {
            minResult = Math.min(minResult, total);
            maxResult = Math.max(maxResult, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cmd[i] > 0) {
                cmd[i]--;
                int next = cal(i, total, arr[currIdx]);
                dfs(currIdx + 1, next);
                cmd[i]++;
            }
        }

    }

    public static int cal(int idx, int a, int b) {
        int result;
        if (idx == 0) {
            result = a + b;
        } else if (idx == 1) {
            result = a - b;
        } else if (idx == 2) {
            result = a * b;
        } else {
            result = a / b;
        }
        return result;
    }
}
