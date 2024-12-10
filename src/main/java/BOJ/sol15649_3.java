package BOJ;

import java.io.*;
import java.util.*;

public class sol15649_3 {
    static int n, m;
    static boolean[] isUsed;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n + 1];
        arr = new int[m + 1];

        func(0);
    }

    public static void func(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[count] = i;
                func(count + 1);
                isUsed[i] = false;
            }
        }
    }
}
