import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] u;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        u = new int[n];

        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }

        sum = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[idx++] = u[i] + u[j];
            }
        }

        Arrays.sort(sum);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = u[i] - u[j];
                if (Arrays.binarySearch(sum, target) > -1) {
                    max = Math.max(max, u[i]);
                }
            }
        }
        System.out.println(max);
    }
}
