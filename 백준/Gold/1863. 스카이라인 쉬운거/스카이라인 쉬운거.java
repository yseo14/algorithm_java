import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); 
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
                count++;
            }

            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
