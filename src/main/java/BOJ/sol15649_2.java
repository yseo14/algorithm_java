package BOJ;

import java.io.*;
import java.util.*;

/**
 * 백트래킹 이해도가 떨어지는 거 같아서 푸는 문제 1
 */

public class sol15649_2 {

    static int N, M;
    static int arr[];
    static boolean isUsed[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        isUsed = new boolean[N + 1];

        backTracking(0);
    }


    public static void backTracking(int count) {
        //  숫자 개수가 M개일 때 return
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[count] = i;
                backTracking(count + 1);
                isUsed[i] = false;
            }

        }
    }
}
