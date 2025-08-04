package BOJ;

import java.io.*;
import java.util.*;

public class sol2179_2 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int max = 0;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i +1; j < n; j++) {
                int count = check(words[i], words[j]);
                if (count != -1) {
                    if (count > max) {
                        first = i;
                        second = j;
                        max = count;
                    }
                }
            }
        }

        System.out.println(words[first]);
        System.out.println(words[second]);

    }

    public static int check(String str1, String str2) {
        if (str1.equals(str2)) {
            return -1;
        }

        int count = 0;
        int length = Math.min(str1.length(), str2.length());

        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
