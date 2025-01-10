package BOJ;

import java.io.*;
import java.util.*;

public class sol18870_3 {
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
            int count = binarySearch(i, 0, temp.length - 1);
            sb.append(count).append(" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (temp[mid] == target) {
            return mid;
        } else if (temp[mid] > target) {
            return binarySearch(target, left, mid - 1);
        } else {
            return binarySearch(target, mid + 1, right);
        }
    }
}
