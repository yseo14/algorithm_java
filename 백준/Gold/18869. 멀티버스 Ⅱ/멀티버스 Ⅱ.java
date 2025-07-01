import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] universes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        universes = new int[m][n];

        for (int i = 0; i < m; i++) {
            int[] uni = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                uni[j] = Integer.parseInt(st.nextToken());
            }
            int[] sorted = Arrays.stream(uni)
                    .sorted()
                    .distinct()
                    .toArray();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < sorted.length; j++) {
                map.put(sorted[j], j);
            }

            for (int j = 0; j < n; j++) {
                universes[i][j] = map.get(uni[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (Arrays.equals(universes[i], universes[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
