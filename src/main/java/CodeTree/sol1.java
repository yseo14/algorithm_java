package CodeTree;

import java.io.*;
import java.util.*;

/**
 * 이상한 진수
 * a를 한 숫자만 바꾼 모든 경우의 수를 저장한다.
 * b도 마찬가지로 모두 저장한다.
 * a와 b를 각각 대조하면서 맞는 숫자를 찾는다.
 * <p>
 * 문자열로 저장한다.
 */

public class sol1 {
    static String a;
    static String b;
    static Long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        Set<Long> possibleBinaryNum = possibleBinarySet(a);
        Set<Long> possibleTernaryNum = possibleTernarySet(b);

        for (Long num : possibleBinaryNum) {
            if (possibleTernaryNum.contains(num)) {
                result = num;
                break;
            }
        }
        System.out.println(result);

    }

    public static Set<Long> possibleBinarySet(String binary) {
        Set<Long> possibleNums = new HashSet<>();
        for (int i = 0; i < binary.length(); i++) {
            char[] chars = binary.toCharArray();
            chars[i] = (chars[i] == '0') ? '1' : '0';
            possibleNums.add(Long.parseLong(new String(chars), 2));
        }
        return possibleNums;
    }

    public static Set<Long> possibleTernarySet(String ternary) {
        Set<Long> possibleNums = new HashSet<>();
        for (int i = 0; i < ternary.length(); i++) {
            char[] chars = ternary.toCharArray();
            char originChar = chars[i];
            for (char c = '0'; c <= '2'; c++) {
                if (c != originChar) {
                    chars[i] = c;
                    possibleNums.add(Long.parseLong(new String(chars), 3));
                }
            }
        }
        return possibleNums;
    }
}