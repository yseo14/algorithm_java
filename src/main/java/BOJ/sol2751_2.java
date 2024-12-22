package BOJ;

import java.io.*;

public class sol2751_2 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(0, N);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int pivot = arr[start];
        int left = start + 1;
        int right = end - 1;
        while (true) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] >= pivot) {
                right--;
            }
            if (left > right) {
                break;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        int temp = arr[start];
        arr[start] = arr[right];
        arr[right] = temp;
        quickSort(start, right);
        quickSort(right + 1, end);
    }
}
