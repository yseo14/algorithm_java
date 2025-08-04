package BOJ;

import java.io.*;
import java.util.*;

public class sol1244 {
    static int n, m;
    static int status = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                status |= (1 << i);
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                boy(num);
            } else {
                girl(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((status >> i) & 1).append(" ");
            if ((i + 1) % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void boy(int num) {
        int i = 1;
        while (num * i <= n) {
            status ^= (1 << (num * i - 1));
            i++;
        }
    }

    public static void girl(int num) {
        status ^= (1 << (num - 1)); //  부여 받은 번호는 무조건 바뀜
        int i = 1;
        while (num + i <= n && num - i >= 1) {
            if (getBit(status, num + i - 1) == getBit(status, num - i - 1)) {
                status ^= (1 << (num + i - 1));
                status ^= (1 << (num - i - 1));
            } else {
                return;
            }
            i++;
        }

    }

    public static int getBit(int num, int n) {
        return (num >> n) & 1;
    }
}
