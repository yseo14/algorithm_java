package Softeer;

import java.io.*;
import java.util.*;

/**
 * 계산 결과가 int의 범위를 넘어설 수 있기 때문에 Long으로 타입을 지정해주고,
 * 나머지 연산을 마지막이 아닌 반복문의 중간에 함으로써 수가 커지는 것을 방지해야한다. 
 */

public class sol6284 {
    static long K,P,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 1;i<=N;i++){
            K *= P;
            K %= 1000000007;
        }
        System.out.println(K);
    }
}
