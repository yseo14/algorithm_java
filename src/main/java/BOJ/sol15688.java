package BOJ;

import java.io.*;
import java.util.*;

public class sol15688 {
    static int n;
    static int[] arr = new int[2000002];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[tmp + 1000000]++;
        }

        for (int i = 0; i < 2000002; i++) {
            while (arr[i] > 0) {
                sb.append(i - 1000000).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}
