import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int left = 0; left < n; left++) {
            int right = left;
            while (right < n && Math.abs(arr[left] - arr[right]) < m) {
                right++;
            }
            if (right >= n) {
                continue;
            }
            min = Math.min(min, Math.abs(arr[left] - arr[right]));
        }
        System.out.println(min);
    }
}
