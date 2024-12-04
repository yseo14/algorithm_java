import java.io.*;
import java.util.*;

public class Main {
    static long a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(func(a, b));
    }

    public static long func(long n, long m) {
        if (m == 1) {
            return n % c;
        }
        long temp = func(n, m / 2);
        if (m % 2 == 1) {
            return (temp * temp % c) * n % c;
        }
        return temp * temp % c;
    }
}
