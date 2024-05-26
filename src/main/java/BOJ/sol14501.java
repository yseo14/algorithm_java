package BOJ;

import java.util.*;
import java.io.*;


public class sol14501 {

    static int n;
    static int[] t;
    static int[] p;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        t = new int[n + 1]; //  1일차를 배열 인덱스 1번으로 맞추기 위해 +1
        p = new int[n + 1];
        dp = new int[n + 2];    //  퇴사 전 날(n+1) 까지 상담을 할 수 있기 때문에 +2

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            if (i + t[i] - 1 > n) { //  당일(i)부터 상담을 시작하므로 -1 (만약 n이 7이고 i가 5, t[i] = 3이면 6,7,8일을 상담하는 것이 아닌 5,6,7을 상담하므로)
                //  상담을 시작하면 마지막 근무 일을 넘어 상담 불가할 경우
                dp[i] = dp[i + 1];  //  다음 날의 최대 수익과 동일
            } else {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);  //  현재 일자에 상담하지 않았을 경우(즉, 다음날로 넘어갔을 경우의 최대 수익)과 현재 일자에 상담하여 생기는 수익 + 상담이 끝났을 때 일자의 최대 수익 중 큰 값을 저장
            }
        }

        System.out.println(dp[1]);
    }
}
