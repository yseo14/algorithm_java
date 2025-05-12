package BOJ;

import java.io.*;
import java.util.*;

public class sol4659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        while (true) {
            String pwd = br.readLine();
            if (pwd.equals("end")) {
                break;
            }

            boolean hasVowel = false;
            boolean isAcceptable = true;

            int vowelCount = 0; //  모음 연속 개수
            int consonantCount = 0; //  자음 연속 개수

            for (int i = 0; i < pwd.length(); i++) {
                char curr = pwd.charAt(i);

                // 모음 포함 여부
                if (vowels.contains(curr)) {
                    hasVowel = true;
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                // 모음 3개 또는 자음 3개 연속 검사
                if (vowelCount == 3 || consonantCount == 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 글자 두 번 연속 검사 (단 ee, oo는 허용)
                if (i > 0) {
                    char prev = pwd.charAt(i - 1);
                    if (curr == prev && !(curr == 'e' || curr == 'o')) {
                        isAcceptable = false;
                        break;
                    }
                }
            }

            if (hasVowel && isAcceptable) {
                System.out.println("<" + pwd + "> is acceptable.");
            } else {
                System.out.println("<" + pwd + "> is not acceptable.");
            }
        }
    }
}
