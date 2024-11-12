package Softeer;

import java.io.*;
import java.util.*;

public class sol6292 {
    static long k, p, n;
    static long answer;
    private static long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        n = Long.parseLong(st.nextToken());

        n *= 10;
        answer = (k * func(p, n)) % MOD;
        System.out.println(answer);
    }

    public static long func(long p, long n) {
        if (n == 1) {
            return p;
        }
        long result = func(p, n / 2);
        if (n % 2 == 0) {
            return (result * result) % MOD;
        } else {
            result *= result;
            result %= MOD;
            return (result * p) % MOD;
        }
    }
}
