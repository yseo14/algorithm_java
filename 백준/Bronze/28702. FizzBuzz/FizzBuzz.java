import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = -1;
        int idx = -1;
        for (int i = 1; i <= 3; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            if (c != 'F' && c != 'B') {
                num = Integer.parseInt(str);
                idx = i;
                break;
            }
        }
        num = num + (3 - idx) + 1;

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0 && num % 5 != 0) {
            System.out.println("Fizz");
        } else if (num % 3 != 0 && num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}
