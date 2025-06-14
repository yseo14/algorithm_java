package BOJ;

import java.io.*;
import java.util.*;


/**
 * 해시셋에 단축키 저장 1. 단어의 첫글자 2. 그냥 왼쪽에서부터
 */

public class sol1283_2 {
    static int n;
    static HashSet<Character> shortcuts = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            int sc = firstChar(option);
            if (sc == -1) {
                sc = fromLeft(option);
            }

            if (sc == -1) {
                sb.append(option);
            } else {
                for (int j = 0; j < option.length(); j++) {
                    if (j == sc) {
                        sb.append('[').append(option.charAt(j)).append(']');
                    } else {
                        sb.append(option.charAt(j));
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int firstChar(String option) {
        String[] words = option.split(" ");
        int idx = 0;
        for (String word : words) {
            char first = Character.toLowerCase(word.charAt(0));
            if (!shortcuts.contains(first)) {
                shortcuts.add(first);
                return idx;
            }
            idx += word.length() + 1;
        }
        return -1;
    }

    public static int fromLeft(String option) {
        for (int i = 0; i < option.length(); i++) {
            char c = Character.toLowerCase(option.charAt(i));
            if (!shortcuts.contains(c) && c != ' ') {
                shortcuts.add(c);
                return i;
            }
        }
        return -1;
    }
}
