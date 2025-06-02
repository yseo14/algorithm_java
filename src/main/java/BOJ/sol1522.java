package BOJ;

import java.io.*;
import java.util.*;

public class sol1522 {
    static String str;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int end = i + count;
            int bCount = 0;
            for (int j = i; j < end; j++) {
                int idx = j % str.length();
                if (str.charAt(idx) == 'b') {
                    bCount++;
                }
            }
            min = Math.min(min, bCount);
        }
        System.out.println(min);
    }
}
