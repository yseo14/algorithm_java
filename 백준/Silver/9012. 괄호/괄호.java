import java.io.*;
import java.util.*;

public class Main {
    static int t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            System.out.println(isVps(br.readLine()));
        }
    }

    public static String isVps(String input) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (s.isEmpty() || curr == '(') {
                s.push(curr);
            } else {
                if (s.peek() == '(') {
                    s.pop();
                } else {
                    s.push(curr);
                }
            }
        }
        if (s.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
