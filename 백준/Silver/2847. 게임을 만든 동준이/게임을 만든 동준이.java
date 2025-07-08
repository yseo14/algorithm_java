import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int prev = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= prev) {
                int amount = arr[i] - prev + 1;
                result += amount;
                prev = arr[i] - amount;
            } else {
                prev = arr[i];
            }
        }
        System.out.println(result);
    }
}
