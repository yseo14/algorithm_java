package BOJ;

import java.io.*;
import java.util.*;

public class sol5525 {
    static int n, m;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        int length = 2 * n + 1;
        int start = 0;
        int end = 0;

        while (end < s.length() - 1) {
            while (s.charAt(start) != 'I') {
                start++;
            }
        }
    }
}
