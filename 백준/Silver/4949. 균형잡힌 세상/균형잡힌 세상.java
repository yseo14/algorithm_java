import java.io.*;
import java.util.*;

public class Main {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            stack.clear();
            String str = br.readLine();
            boolean isValid = true;
            if (str.equals(".")) {
                break;
            }
            String[] sentence = str.split("");
            for (String s : sentence) {
                switch (s) {
                    case "(":
                    case "[":
                        stack.push(s);
                        break;
                    case ")":
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            isValid = false;
                        }
                        break;
                    case "]":
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            isValid = false;
                        }
                        break;
                }
            }
            if (!stack.isEmpty()) {
                isValid = false;
            }
            if (isValid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
