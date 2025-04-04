package BOJ;

import java.io.*;

public class sol1094_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;

        while (x > 0) {
            if ((x & 1) == 1) count++; // 하위 비트가 1이면 막대기 하나 필요
            x >>= 1; // 오른쪽으로 한 칸 시프트 (다음 비트로 이동)
        }

        System.out.println(count);
    }
}