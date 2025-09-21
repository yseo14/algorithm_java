import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int n;
    static int[] scores;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            scores = new int[n + 1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int count = 1;
            int standard = scores[1];
            for (int i = 2; i <= n; i++) {
                if (scores[i] < standard) {
                    standard = scores[i];
                    count++;
                }
            }

            System.out.println(count);

        }
    }
}
