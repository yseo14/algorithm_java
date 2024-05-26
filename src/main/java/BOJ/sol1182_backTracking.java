package BOJ;

import java.util.*;
import java.io.*;

public class sol1182_backTracking {

    static int[] arr;
    static boolean[] isUsed;
    static int[] partArr;
    static int cnt;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        isUsed = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //  1 ~ n까지 몇 개의 숫자들로 수열을 구성할지 정함
        for (int i = 1; i <= n; i++) {
            partArr = new int[i];
            func(0, 0, i);
        }
        System.out.println(cnt);

    }

    public static void func(int index, int start, int maxLength) {
        if (maxLength == index) {
            int sum = 0;
            for (int num : partArr) {
                sum += num;
            }
            if (sum == s) {
                cnt++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                partArr[index] = arr[i];
                func(index + 1, i+1, maxLength);
                isUsed[i] = false;
            }
        }
    }

}
