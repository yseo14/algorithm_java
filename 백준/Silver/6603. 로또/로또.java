import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] num;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static int[] selected = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            isUsed = new boolean[50];
            num = new int[k];
            for (int i = 0; i < k; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int count, int start) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            selected[count] = num[i];
            dfs(count + 1, i + 1);
        }
    }
}
