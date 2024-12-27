package BOJ;

import java.io.*;
import java.util.*;

/**
 * 입력 받는 시리얼번호를 한글자씩 나누고 숫자일 경우 값을 더한다.
 */

public class sol1431 {
    static int n;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                int sum1 = sum(s1);
                int sum2 = sum(s2);
                if (sum1 == sum2) {
                    return s1.compareTo(s2);
                } else {
                    return sum1 - sum2;
                }
            } else {
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static int sum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        return sum;
    }

}
