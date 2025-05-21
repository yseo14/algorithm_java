package BOJ;

import java.io.*;
import java.util.*;

public class sol2138 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String originStr = br.readLine();
        String targetStr = br.readLine();

        int[] origin = new int[n];
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            origin[i] = originStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }

        // case 1: 첫 번째 스위치를 누름
        int[] temp = origin.clone();
        int count1 = 1;
        toggle(temp, 0);
        for (int i = 1; i < n; i++) {
            if (temp[i - 1] != target[i - 1]) {
                count1++;
                toggle(temp, i);
            }
        }
        boolean case1 = Arrays.equals(temp, target);

        // case 2: 첫 번째 스위치를 누르지 않음
        temp = origin.clone();
        int count2 = 0;
        for (int i = 1; i < n; i++) {
            if (temp[i - 1] != target[i - 1]) {
                count2++;
                toggle(temp, i);
            }
        }
        boolean case2 = Arrays.equals(temp, target);

        if (!case1 && !case2) {
            System.out.println(-1);
        } else if (case1 && case2) {
            System.out.println(Math.min(count1, count2));
        } else if (case1) {
            System.out.println(count1);
        } else {
            System.out.println(count2);
        }
    }

    static void toggle(int[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < arr.length) {
                arr[i] ^= 1;
            }
        }
    }
}
