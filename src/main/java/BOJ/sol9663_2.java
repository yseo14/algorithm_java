package BOJ;

import java.io.*;

public class sol9663_2 {
    static int N;
    static int answer = 0;
    static boolean[] isUsed1;
    static boolean[] isUsed2;   //  우상향 대각선
    static boolean[] isUsed3;   //  우하향 대각선

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isUsed1 = new boolean[N];
        isUsed2 = new boolean[2 * N - 1];
        isUsed3 = new boolean[2 * N - 1];
        queen(0);
        System.out.println(answer);
    }

    public static void queen(int count) {
        if (count == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[i + count] || isUsed3[count - i + N - 1]) {
                continue;
            }
            isUsed1[i] = true;
            isUsed2[i + count] = true;
            isUsed3[count - i + N - 1] = true;
            queen(count + 1);
            isUsed1[i] = false;
            isUsed2[i + count] = false;
            isUsed3[count - i + N - 1] = false;
        }
    }
}
