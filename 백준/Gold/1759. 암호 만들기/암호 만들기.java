import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static String[] str, pwd;
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static int vowelsCnt = 0, consonantsCnt = 0;
    static boolean[] isUsed = new boolean[16];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        str = new String[c];
        pwd = new String[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            str[i] = st.nextToken();
        }
        Arrays.sort(str);
        backtracking(0,0);
        bw.flush();
        bw.close();
    }

    public static void backtracking(int start, int depth) throws Exception {
        if (depth == l) {
            if (vowelsCnt >= 1 && consonantsCnt >= 2) {
                for (int i = 0; i < depth; i++) {
                    bw.write(pwd[i]);
                }
                bw.write("\n");
            }
            return;
        }
        for (int i = start; i < c; i++) {
            if (!isUsed[i]) {
                int isVowels = Arrays.binarySearch(vowels, str[i]);
                if (isVowels >= 0) {
                    vowelsCnt++;
                } else {
                    consonantsCnt++;
                }
                pwd[depth] = str[i];
                isUsed[i] = true;
                backtracking(i + 1, depth + 1);
                if (isVowels >= 0) {
                    vowelsCnt--;
                } else {
                    consonantsCnt--;
                }
                isUsed[i] = false;
            }
        }

    }
}
