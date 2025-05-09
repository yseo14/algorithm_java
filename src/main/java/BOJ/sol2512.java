package BOJ;

import java.io.*;
import java.util.*;

public class sol2512 {
    static int n;
    static int[] arr;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        int low = 1;
        int high = arr[n - 1] + 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (budgetSum(mid) > m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }

    public static int budgetSum(int val) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(arr[i], val);
        }
        return sum;
    }
}
