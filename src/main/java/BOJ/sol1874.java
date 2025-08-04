package BOJ;

import java.io.*;
import java.util.*;

public class sol1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int curr = 0;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target > curr) {
                while (curr < target) {
                    stack.push(++curr);
                    sb.append("+\n");
                }
            }

            if (stack.isEmpty() || stack.peek() != target) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.print(sb);
    }
}
