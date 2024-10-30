package BOJ;

import java.io.*;
import java.util.*;

public class sol1919 {
    static String str1;
    static String str2;
    static char[] arr1;
    static char[] arr2;
    static int[] counts;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        counts = new int[150];
        for (char c : arr1) {
            counts[c]++;
        }
        for (char c : arr2) {
            counts[c]--;
        }
        for (int count : counts) {
            if (count != 0) {
                result += Math.abs(count);
            }
        }
        System.out.println(result);
    }
}
