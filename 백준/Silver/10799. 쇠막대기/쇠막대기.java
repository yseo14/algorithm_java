import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> s = new Stack<>();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(') {
                s.push(curr);
            } else {
                s.pop();
                if (input.charAt(i - 1) == '(') {
                    count += s.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
