package BOJ;

import java.io.*;
import java.util.*;

public class sol2179 {
    static int n;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int max = 0;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = check(words[i], words[j]);
                if (count != -1) {
                    if (max < count) {
                        max = count;
                        first = i;
                        second = j;
                    }
                }
            }
        }

        System.out.println(words[first]);
        System.out.println(words[second]);
    }

    public static int check(String s1, String s2) {
        int count = 0;
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            count++;
        }
        if (s1.equals(s2)) {
            return -1;
        }
        return count;
    }
}