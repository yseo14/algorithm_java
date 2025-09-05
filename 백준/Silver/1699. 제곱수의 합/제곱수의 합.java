import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for (int i = 1; i <= n; i++) {
            for (int sq : squares) {
                if (sq > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
                
            }
        }
        System.out.println(dp[n]);
    }
}
