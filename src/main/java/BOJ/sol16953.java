package BOJ;

import java.io.*;
import java.util.*;

public class sol16953 {
    static long a, b;
    static int result = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        while (a != b) {
            if (b < a) {
                result = -1;
                break;
            }
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                result = -1;
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}
