package BOJ;

import java.io.*;
import java.util.*;

public class sol1406_stack {
    static String init;
    static int M;

    static Stack<Character> left;
    static Stack<Character> right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init = br.readLine();
        left = new Stack<>();
        right = new Stack<>();
        for (int i = 0; i < init.length(); i++) {
            left.push(init.charAt(i));
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char add = command.charAt(2);
                   left.push(add);
                    break;

                default:
                    break;
            }
        }
       while(!left.isEmpty()) {
            right.push(left.pop());
        }
        while(!right.isEmpty()) {
            bw.write(right.pop());
        }
        bw.flush();
        bw.close();
    }
}