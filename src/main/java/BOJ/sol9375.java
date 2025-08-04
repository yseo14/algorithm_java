package BOJ;

/**
 * 조합.
 */

import java.io.*;
import java.util.*;

public class sol9375 {
    static int t;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                if (!map.containsKey(category)) {
                    map.put(category, 1);
                } else {
                    int amount = map.get(category);
                    map.put(category, amount + 1);
                }
            }

            int result = 1;
            for (int val : map.values()) {
                result *= val + 1;
            }
            System.out.println(result - 1);
        }
    }
}
