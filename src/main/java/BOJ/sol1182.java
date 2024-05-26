package BOJ;

import java.util.*;
import java.io.*;

public class sol1182 {

    static int[] arr;
    static int cnt;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (s == 0) System.out.println(cnt - 1); //  아무것도 선택하지 않았을 때(부분수열의 원소가 0개일 때 뺴줌)
        else System.out.println(cnt);

    }

    public static void func(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }

        func(index + 1, sum + arr[index]);
        func(index + 1, sum);
    }

}
