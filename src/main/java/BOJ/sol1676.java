package BOJ;

import java.io.*;

public class sol1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            cnt += n / i;
        }

        System.out.println(cnt);
    }
}
