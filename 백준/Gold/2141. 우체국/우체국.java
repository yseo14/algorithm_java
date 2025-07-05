import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Town[] towns = new Town[n];
        long pop = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            pop += a;
            towns[i] = new Town(x, a);
        }

        Arrays.sort(towns, (t1, t2) -> t1.x - t2.x);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += towns[i].a;
            if (sum >= (pop + 1) / 2) {
                System.out.println(towns[i].x);
                break;
            }
        }
    }

    public static class Town {
        int x, a;

        public Town(int x, int a) {
            this.x = x;
            this.a = a;
        }
    }
}
