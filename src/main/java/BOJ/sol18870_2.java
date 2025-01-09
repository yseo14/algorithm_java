package BOJ;

import java.io.*;
import java.util.*;

public class sol18870_2 {
    static int n;
    static int[] origin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        origin = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 및 중복 제거
        int[] temp = Arrays.stream(origin)
                .distinct()
                .sorted()
                .toArray();

        // 값 -> 인덱스 매핑
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i);
        }

        // 결과 생성
        for (int key : origin) {
            sb.append(map.get(key)).append(" ");
        }

        System.out.println(sb);
    }
}
