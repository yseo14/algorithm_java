package BOJ;

import java.io.*;
import java.util.Stack;

public class sol5397 {

    static int T;
    static Stack<Character> left;
    static Stack<Character> right;
    static String init;
    static char[] log;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init = br.readLine();
            log = init.toCharArray();
            left = new Stack<>();
            right = new Stack<>();

            for (char c : log) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;

                    case '-':
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                bw.write(right.pop());
            }
            if (i != T - 1) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
