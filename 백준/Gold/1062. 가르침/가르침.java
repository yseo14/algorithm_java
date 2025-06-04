import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] used = new boolean[26];
    static int max = 0;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        used['a' - 'a'] = true;
        used['c' - 'a'] = true;
        used['n' - 'a'] = true;
        used['t' - 'a'] = true;
        used['i' - 'a'] = true;

        if (k < 5) {
            System.out.println(0);
        } else if (k == 26) {
            System.out.println(n);
        } else {
            dfs(0, 0);
            System.out.println(max);
        }
    }

    public static void dfs(int idx, int depth) {
        if (depth + 5 == k) {
            countWord();
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            dfs(i + 1, depth + 1);
            used[i] = false;
        }
    }

    public static void countWord() {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            for (int i = 0; i < word.length(); i++) {
                if (!used[word.charAt(i) - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable) {
                count++;
            }
        }
        max = Math.max(max, count);
    }
}
