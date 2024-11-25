import java.util.*;
import java.io.*;

/**
 * 레이저를 판단한다.
 * 레이저가 자르는 시점에 스택 안에 있는 여는괄호의 수가 생기는 조각 수이다.
 * 닫는 괄호가 나오면 조각이 하나 생기고, 스택에 여는괄호 한개를 지운다.
 */
public class Main {
    static Stack<String> stack = new Stack<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] separated = str.split("");

        for (int i = 0; i < separated.length; i++) {
            String curr = separated[i];
            switch (curr) {
                case "(":
                    stack.push(curr);
                    break;
                case ")":
                    if (!stack.isEmpty() && separated[i - 1].equals("(")) { //  레이저
                        stack.pop();    //  레이저 앞부분 제거
                        count += stack.size();
                    } else {
                        stack.pop();
                        count++;
                    }
                    break;
            }
        }
        System.out.println(count);
    }
}
