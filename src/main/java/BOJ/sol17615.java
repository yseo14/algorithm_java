package BOJ;

import java.io.*;
import java.util.*;

public class sol17615 {
    static int n;
    static String str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        int count = Integer.MAX_VALUE;

        //  B를 전부 오른쪽으로
        int leftFirstB = -1;
        int rCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'B') {
                leftFirstB = i;
            }
            if (leftFirstB != -1 && i > leftFirstB) {
                if (str.charAt(i) == 'R') {
                    rCount++;
                }
            }
        }
        count = rCount;

        //  B를 전부 왼쪽으로
        int rightFirstB = str.length();
        rCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') {
                rightFirstB = i;
            }
            if (rightFirstB != str.length() && i < rightFirstB) {
                if (str.charAt(i) == 'R') {
                    rCount++;
                }
            }
        }
        count = Math.min(rCount, count);

        //  R을 전부 오른쪽으로
        int leftFirstR = -1;
        int bCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                leftFirstR = i;
            }
            if (leftFirstR != -1 && i > leftFirstR) {
                if (str.charAt(i) == 'B') {
                    bCount++;
                }
            }
        }
        count = Math.min(bCount, count);

        //  R을 전부 왼쪽으로
        int rightFirstR = str.length();
        bCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') {
                rightFirstR = i;
            }
            if (rightFirstR != str.length() && i < rightFirstR) {
                if (str.charAt(i) == 'B') {
                    bCount++;
                }
            }
        }
        count = Math.min(bCount, count);

        System.out.println(count);
    }
}
