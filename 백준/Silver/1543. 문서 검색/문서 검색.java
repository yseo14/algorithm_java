import java.io.*;
import java.util.*;

public class Main {
    static String doc;
    static String word;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        doc = br.readLine();
        word = br.readLine();

        char[] docArr = new char[doc.length()];
        for (int i = 0; i < doc.length(); i++) {
            docArr[i] = doc.charAt(i);
        }
        char[] wordArr = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordArr[i] = word.charAt(i);
        }

        int result = 0;
        for (int i = 0; i <= doc.length() - word.length(); i++) {
            int count = 0;
            int startIdx = i;
            while (startIdx <= doc.length() - word.length()) {
                int same = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (docArr[j + startIdx] == (wordArr[j])) {
                        same++;
                    } else {
                        break;
                    }
                }
                if (same == word.length()) {
                    count++;
                    startIdx += word.length();
                } else {
                    startIdx++;
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}
