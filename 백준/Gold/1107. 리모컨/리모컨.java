import java.io.*;
import java.util.*;

public class Main {

    static boolean[] broken = new boolean[10];

    // x를 숫자 버튼만으로 입력 가능하면 그 자릿수(누름 수)를 반환, 불가능하면 -1
    static int canType(int x) {
        if (x == 0) {
            return broken[0] ? -1 : 1; // 0 한 자리
        }
        int len = 0;
        while (x > 0) {
            int d = x % 10;
            if (broken[d]) return -1;
            len++;
            x /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 플랜 A: +/-만 사용
        int answer = Math.abs(N - 100);

        // 플랜 B: 숫자 + +/-
        // 0 ~ 1,000,000 까지 시도 (상한 여유)
        for (int x = 0; x <= 1_000_000; x++) {
            int len = canType(x);
            if (len == -1) continue;
            int press = len + Math.abs(N - x);
            if (press < answer) answer = press;
        }

        System.out.println(answer);
    }
}
