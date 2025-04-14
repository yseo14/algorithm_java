package BOJ;

import java.io.*;
import java.util.*;

public class sol2110 {
    static int n, c;           // n: 집의 개수, c: 공유기의 개수
    static int[] house;        // 집의 좌표를 저장하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 개수와 설치할 공유기 개수 입력 받기
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        // 각 집의 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // 공유기 설치를 위해 집을 좌표 순서대로 정렬
        Arrays.sort(house);

        // 이분 탐색 시작
        int low = 1;  // 최소 거리: 공유기 간격의 최소값 (0은 불가능하므로 1부터 시작)
        int high = house[n - 1] - house[0] + 1;
        // 최대 거리: 제일 먼 집 간의 거리 + 1 (upper bound 탐색을 위해 +1)

        // 이분 탐색 반복: 탐색 범위가 좁혀질 때까지 반복
        while (low < high) {
            int mid = (low + high) / 2;  // 현재 시도해보는 공유기 간 최소 거리

            // mid 간격으로 공유기를 설치했을 때 설치 가능한 공유기 수 확인
            if (installed(mid) < c) {
                // 설치 가능한 공유기 수가 부족하다면 → 간격이 너무 넓은 것
                // 따라서 간격을 줄이기 위해 탐색 범위를 왼쪽으로 좁힘
                high = mid;
            } else {
                // 설치 가능한 공유기 수가 충분하다면 → 더 넓게 설치 가능할 수도 있음
                // 따라서 간격을 넓히기 위해 탐색 범위를 오른쪽으로 이동
                low = mid + 1;
            }
        }

        // upper bound 방식이므로, 최댓값은 low - 1
        System.out.println(low - 1);
    }

    // 주어진 거리(dist) 간격으로 공유기를 설치했을 때, 설치 가능한 공유기 수 리턴
    public static int installed(int dist) {
        int cnt = 1;  // 첫 번째 집에는 무조건 공유기 설치
        int prev = house[0];  // 이전에 공유기를 설치한 위치

        // 두 번째 집부터 순차적으로 확인
        for (int i = 1; i < n; i++) {
            int curr = house[i];

            // 이전 공유기 설치 위치와의 거리가 dist 이상이면 설치 가능
            if (curr - prev >= dist) {
                cnt++;       // 공유기 설치
                prev = curr; // 마지막 설치 위치 갱신
            }
        }

        return cnt;  // 최종적으로 설치한 공유기 개수 리턴
    }
}
