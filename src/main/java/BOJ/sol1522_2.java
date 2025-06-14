package BOJ;

import java.io.*;
import java.util.*;

public class sol1522_2 {
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                int idx = j % str.length();
                if (str.charAt(idx) == 'b') {
                    bCnt++;
                }
            }
            ans = Math.min(ans, bCnt);
        }
        System.out.println(ans);
    }
}
