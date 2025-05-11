import java.io.*;
import java.util.*;

public class Main {
    static int n, x;
    static int[] visitor;
    static ArrayList<Integer> totalList = new ArrayList<>();
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

        int maxTotal = 0;
        for (int i = 1; i <= x; i++) {
            maxTotal += visitor[i];
        }
        totalList.add(maxTotal);

        int prevTotal = maxTotal;
        for (int i = x + 1; i <= n; i++) {
            int currTotal = prevTotal - visitor[i - x] + visitor[i];
            totalList.add(currTotal);
            maxTotal = Math.max(currTotal, maxTotal);
            prevTotal = currTotal;
        }
        if (maxTotal == 0) {
            System.out.println("SAD");
        } else {
            int count= 0;
            for (int total : totalList) {
                if (total == maxTotal) {
                    count++;
                }
            }
            System.out.println(maxTotal);
            System.out.println(count);
        }
    }
}
