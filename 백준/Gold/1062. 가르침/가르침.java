import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static String[] words;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.substring(4, word.length() - 4);
            words[i] = word.replaceAll("[acint]", "");
        }
        int mask = 0;
        mask |= (1 << 'a' - 'a');
        mask |= (1 << 'n' - 'a');
        mask |= (1 << 't' - 'a');
        mask |= (1 << 'i' - 'a');
        mask |= (1 << 'c' - 'a');

        comb(0, 0, mask);
        System.out.println(ans);
    }

    public static void comb(int idx, int count, int mask) {
        if (count == k - 5) {
            countWord(mask);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if ((mask & (1 << i)) == 0) {
                comb(i + 1, count + 1, mask | (1 << i));
            }
        }
    }

    public static void countWord(int mask) {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            for (int i = 0; i < word.length(); i++) {
                if ((mask & (1 << word.charAt(i) - 'a')) == 0) {
                    readable = false;
                    break;
                }
            }
            if (readable) {
                count++;
            }
        }
        ans = Math.max(ans, count);
    }
}
