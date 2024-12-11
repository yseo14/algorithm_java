package BOJ;

import java.io.*;
import java.util.*;

public class sol1182_2 {
    static int N, S;
    static int result = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (S == 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }

    }

    public static void func(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                result++;
            }
            return;
        }
        func(index + 1, sum + arr[index]);
        func(index + 1, sum);
    }
}
