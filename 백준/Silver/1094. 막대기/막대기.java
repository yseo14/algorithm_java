import java.io.*;

public class Main {
    static int x;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        int exp = 6;
        int sum = 0;
        while (true) {
            if (sum + Math.pow(2, exp) > x) {
                exp--;
            } else {
                sum += (int) Math.pow(2, exp);
                result++;
            }
            if (sum == x) {
                break;
            }
        }
        System.out.println(result);
    }
}
