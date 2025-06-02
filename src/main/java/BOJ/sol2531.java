package BOJ;

import java.io.*;
import java.util.*;

public class sol2531 {
    static int n, d, k, c;
    static int[] sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] ate = new int[d + 1]; //  초밥 번호는 1번부터 시작

        //  초기 값 세팅
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (ate[sushi[i]] == 0) { //  먹은 적이 없으면
                count++;
            }
            ate[sushi[i]]++;
        }
        if (ate[c] == 0) {
            max = count + 1;
        }

        for (int i = 1; i < n; i++) {
            int end = (i + k - 1) % n;
            if (ate[sushi[end]] == 0) { //  처음 먹는 종류라면
                count++;
            }
            ate[sushi[end]]++;

            ate[sushi[i - 1]]--;
            if (ate[sushi[i - 1]] == 0) {
                count--;
            }

            if (ate[c] == 0) {
                max = Math.max(count + 1, max);
            } else {
                max = Math.max(count, max);
            }
        }

        System.out.println(max);
    }
}
