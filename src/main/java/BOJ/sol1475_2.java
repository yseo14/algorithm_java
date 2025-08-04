package BOJ;

import java.io.*;
import java.util.*;

public class sol1475_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(func(input));
    }

    public static int func(String input) {
        int[] count = new int[10];
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '6' || curr == '9') {
                count[6]++;
            } else {
                count[curr - '0']++;
            }
        }
        if (count[6] % 2 == 0) {
            count[6] /= 2;
        } else {
            count[6] = count[6] / 2 + 1;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, count[i]);
        }

        return max;
    }
}
