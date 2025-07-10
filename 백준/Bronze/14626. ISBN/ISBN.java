import java.io.*;
import java.util.*;

public class Main {
    static String isbn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isbn = br.readLine();

        int sum = 0;
        int destroyedIdx = -1;
        for (int i = 0; i < 12; i++) {
            int mul = (i % 2 == 0) ? 1 : 3;
            if (isbn.charAt(i) == '*') {
                destroyedIdx = i;
                continue;
            }
            sum += Integer.parseInt(String.valueOf(isbn.charAt(i))) * mul;
        }
        int check = Integer.parseInt(String.valueOf(isbn.charAt(12)));

        int result = 0;
        int destroyedMul = 0;
        if (destroyedIdx % 2 == 0) {
            destroyedMul = 1;
        } else {
            destroyedMul = 3;
        }
        for (int i = 0; i < 10; i++) {
            if ((sum + i * destroyedMul + check) % 10 == 0) {
                result = i;
            }
        }

        System.out.println(result);
    }
}
