package BOJ;

import java.io.*;
import java.util.*;

public class sol1543_2 {
    static String doc;
    static String word;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        doc = br.readLine();
        word = br.readLine();

        int count = 0;
        int startIdx = 0;
        while (startIdx <= doc.length() - word.length()) {
            if (doc.startsWith(word, startIdx)) {
                count++;
                startIdx += word.length();
            } else {
                startIdx++;
            }
        }
        System.out.println(count);
    }
}
