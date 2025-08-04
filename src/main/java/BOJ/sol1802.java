package BOJ;

import java.io.*;
import java.util.*;

public class sol1802 {
    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            char[] arr = input.toCharArray();

            System.out.println(foldable(arr, 0, arr.length - 1) ? "YES" : "NO");
        }
    }

    public static boolean foldable(char[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }

        int mid = (left + right) / 2;

        for (int i = 1; i <= mid - left; i++) {
            if (arr[mid + i] == arr[mid - i]) {
                return false;
            }
        }

        return foldable(arr, left, mid - 1) && foldable(arr, mid + 1, right);
    }

}
