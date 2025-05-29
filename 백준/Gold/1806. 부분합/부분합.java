import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= s) {
                System.out.println(1);
                return;
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                min = Math.min(min, right - left);
                sum -= arr[left++];
            } else if (right == n) {
                break;
            } else {
                sum += arr[right++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
