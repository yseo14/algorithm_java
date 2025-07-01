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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int left = 0; left < n; left++) {
            int right = left + 1;
            long sum = arr[left];
            while (right < n && sum != m) {
                sum += arr[right];
                right++;
            }
            if (sum == m) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
