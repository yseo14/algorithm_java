import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String line;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    continue;
                }
                arr[line.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                sb.append((char) (i + 'a'));
            }
        }
        System.out.println(sb);
    }
}
