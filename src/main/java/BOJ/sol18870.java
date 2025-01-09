package BOJ;

import java.io.*;
import java.util.*;

/**
 * 원래의 좌표들을 정렬하고, 중복을 제거한 새로운 배열을 만든다. 그 배열에서 이분 탐색을 통해 좌표를 압축한 결과를 도출한다.
 * <p>
 * 압축 방법은 여러가지가 있는 것으로 보인다.
 * 1. Stream의 distinct 사용
 * 2. Set을 사용한 방법
 * 3. ArrayList와 Contains를 사용하는 방법
 * 4. Set + Stream을 사용하는 방법
 */

public class sol18870 {
    static int n;
    static int[] origin;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        origin = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        temp = Arrays.stream(origin)
                .distinct()
                .sorted()
                .toArray();

        for (int i : origin) {
            int count = binarySearch(i, 0, temp.length);
            sb.append(count).append(" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (temp[mid] == target) {
                return mid;
            } else if (temp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
