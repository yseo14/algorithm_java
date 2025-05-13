package BOJ;

import java.io.*;
import java.util.*;

public class sol20922 {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int startIdx = 0;
        int endIdx = 0;
        int answer = 0;
        while (endIdx < n) {
            while (endIdx < n && count[arr[endIdx]] + 1 <= k) {
                count[arr[endIdx]]++;   //  이동할 때 마다 해당 숫자 카운트 증가
                endIdx++;   //  왼쪽으로 end 이동
            }
            answer = Math.max(answer, endIdx - startIdx);
            count[arr[startIdx]]--; //  start를 오른쪽으로 하나 이동시키기 전에 count 감소
            startIdx++; //  오른쪽이 고정된 상태의 최대 길이를 구했으므로 다음 탐색을 위해 오른쪽으로 start 한칸 이동
        }

        System.out.println(answer);
    }
}
