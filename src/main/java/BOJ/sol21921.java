package BOJ;

import java.io.*;
import java.util.*;

public class sol21921 {
    static int n, x;
    static int[] visitor;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visitor = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += visitor[i];
        }

        int maxSum = sum;
        int count = 1;
        for (int i = x + 1; i <= n; i++) {
            sum = sum - visitor[i - x] + visitor[i];
            if (sum > maxSum) {
                maxSum = sum;
                count = 1;
            } else if (sum == maxSum) {
                count++;
            }
        }
        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
