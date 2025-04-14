package BOJ;

import java.io.*;
import java.util.*;

public class sol1918 {
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            switch (curr) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(curr)) {
                        bw.write(stack.pop());
                    }
                    stack.add(curr);
                    break;
                case '(':
                    stack.add(curr);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        bw.write(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    bw.write(curr);
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();

    }

    public static int priority(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
