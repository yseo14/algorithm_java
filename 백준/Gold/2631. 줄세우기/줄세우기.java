import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // LIS 배열
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = Collections.binarySearch(lis, arr[i]);

            if (idx < 0) idx = -idx - 1; // 삽입 위치

            if (idx == lis.size()) {
                lis.add(arr[i]);
            } else {
                lis.set(idx, arr[i]);
            }
        }

        System.out.println(n - lis.size());
    }
}

