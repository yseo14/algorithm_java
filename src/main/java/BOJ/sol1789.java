package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        int num = 1;
        while (true) {
            if (s >= num) {
                s -= num;
            }else {
                break;
            }
            num++;
        }
        System.out.println(--num);
    }
}
