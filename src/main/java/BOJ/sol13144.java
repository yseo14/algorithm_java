package BOJ;

import java.io.*;
import java.util.*;

public class sol13144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[100001];  // 값 범위가 1~100000

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int end = 0;

        for (int start = 0; start < n; start++) {
            while (end < n && !visited[arr[end]]) {
                visited[arr[end]] = true;
                end++;

            }

            // (start ~ end - 1)까지는 모두 유일한 구간
            count += (end - start);

            // 다음 start를 위해 현재 start 위치 해제
            visited[arr[start]] = false;
        }

        System.out.println(count);
    }
}
