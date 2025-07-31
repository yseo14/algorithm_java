import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1: {
                    int x = Integer.parseInt(st.nextToken()) - 1;
                    arr[num] |= (1 << x);
                    break;
                }
                case 2: {
                    int x = Integer.parseInt(st.nextToken()) - 1;
                    arr[num] &= ~(1 << x);
                    break;
                }
                case 3: {
                    arr[num] <<= 1;
                    arr[num] &= (1 << 20) - 1;
                    break;
                }
                case 4: {
                    arr[num] >>= 1;
                    arr[num] &= (1 << 20) - 1;
                    break;
                }

            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());
    }
}
