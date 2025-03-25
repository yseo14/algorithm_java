package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol15655 {
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
        backTracking(arr, 0, 0);
    }

    public static void backTracking(int[] arr, int depth, int prior) {
        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isUsed[i] && nums[i] > prior) {
                arr[depth] = nums[i];
                isUsed[i] = true;
                backTracking(arr, depth + 1, nums[i]);
                isUsed[i] = false;
            }
        }
    }
}
