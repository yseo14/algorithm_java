import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] isUsed;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isUsed = new boolean[N + 1];
        arr = new int[N + 1];
        func(0, 1);
    }

    public static void func(int count, int start) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[count] = i;
                func(count + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}
