import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int total = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        while (pq.size() > 1) {
            long sum = 0;
            long n1 = pq.poll();
            long n2 = pq.poll();
            sum = n1 + n2;
            total += sum;
            pq.add(sum);
        }
        System.out.println(total);
    }
}
