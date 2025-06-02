package BOJ;

import java.io.*;
import java.util.*;

public class sol1253 {
    static int n;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            func(i, 0, n - 1);
        }
        System.out.println(answer);
    }

    public static void func(int targetIdx, int left, int right) {
        while (left < right) {
            if (left == targetIdx) {
                left++;
                continue;
            }
            if (right == targetIdx) {
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum < arr[targetIdx]) {
                left++;
            } else if (sum > arr[targetIdx]) {
                right--;
            } else {
                answer++;
                return;
            }
        }
    }
}
