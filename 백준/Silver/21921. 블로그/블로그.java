import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitor = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += visitor[i];
        }

        int maxTotal = sum;
        int count = 1;

        for (int i = x + 1; i <= n; i++) {
            sum = sum - visitor[i - x] + visitor[i];
            if (sum > maxTotal) {
                maxTotal = sum;
                count = 1;
            } else if (sum == maxTotal) {
                count++;
            }
        }

        if (maxTotal == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxTotal);
            System.out.println(count);
        }
    }
}
