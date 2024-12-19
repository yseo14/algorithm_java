import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr1, arr2, arr3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[M];
        arr3 = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < N + M; i++) {
            if (idx1 == N) {
                arr3[i] = arr2[idx2++];
            } else if (idx2 == M) {
                arr3[i] = arr1[idx1++];
            } else if (arr1[idx1] <= arr2[idx2]) {
                arr3[i] = arr1[idx1++];
            } else {
                arr3[i] = arr2[idx2++];
            }
        }

        for (int i = 0; i < N + M; i++) {
            sb.append(arr3[i]+" ");
        }
        System.out.println(sb);
    }
}
