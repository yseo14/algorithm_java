
import java.io.*;
import java.util.*;

public class Main {
    static int temp;
    static int result = 0;
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("");
        temp = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                temp *= 2;
                stack.push(arr[i]);
            } else if (arr[i].equals("[")) {
                temp *= 3;
                stack.push(arr[i]);
            } else if (arr[i].equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    result = 0;
                    break;
                }
                if (arr[i - 1].equals("(")) {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (arr[i].equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    result = 0;
                    break;
                }
                if (arr[i - 1].equals("[")) {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            result = 0;
        }
        System.out.println(result);
    }
}
