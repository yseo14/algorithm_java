import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static HashSet<Character> shortcuts = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            int sc = step1(option);
            if (sc == -1) {
                sc = step2(option);
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

    //  단어의 첫글자
    public static int step1(String option) {
        String[] words = option.split(" ");
        int idx = 0;
        for (String word : words) {
            char c = Character.toLowerCase(word.charAt(0));
            if (!shortcuts.contains(c)) {
                shortcuts.add(c);
                return idx;
            }
            idx += word.length()+ 1;
        }
        return -1;
    }

    //  왼쪽에서부터 차례대로
    public static int step2(String option) {
        for (int i = 0; i < option.length(); i++) {
            char c = option.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (!shortcuts.contains(Character.toLowerCase(c))) {
                shortcuts.add(Character.toLowerCase(c));
                return i;
            }
        }
        return -1;
    }
}
