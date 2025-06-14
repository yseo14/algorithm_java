package BOJ;

import java.io.*;
import java.util.*;

public class sol1052 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //  이진수로 변환했을 때 1의 개수가 k 이하면 가능
        int count = 0;
        while (Integer.bitCount(n) > k) {
            n++;
            count++;
        }
        System.out.println(count);
    }


}
