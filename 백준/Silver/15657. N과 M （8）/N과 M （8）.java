import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] isUsed = new boolean[10001];
    static int[] nums;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
        bw.flush();
        bw.close();
    }

    public static void backTracking(int[] arr, int depth, int prior) throws IOException {
        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= prior) {
                arr[depth] = nums[i];
                isUsed[i] = true;
                backTracking(arr, depth + 1, nums[i]);
                isUsed[i] = false;
            }
        }
    }
}
