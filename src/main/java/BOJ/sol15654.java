package BOJ;

import java.io.*;
import java.util.*;

public class sol15654 {
    static int n, m;
    static boolean[] isUsed = new boolean[10001];
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int[] arr = new int[n];
        backTracking(arr, 0);
    }

    public static void backTracking(int[] arr, int depth) {
        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isUsed[i]) {
                arr[depth] = nums[i];
                isUsed[i] = true;
                backTracking(arr, depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
