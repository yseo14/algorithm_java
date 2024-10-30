package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol10808 {
    static String s;
    static int[] arr;
    static char c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            arr[c - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
