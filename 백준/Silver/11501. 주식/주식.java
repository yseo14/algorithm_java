import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = 0;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (maxPrice < arr[i]) {
                    maxPrice = arr[i];
                } else {
                    sum += maxPrice - arr[i];
                }
            }

            System.out.println(sum);
        }
    }
}
