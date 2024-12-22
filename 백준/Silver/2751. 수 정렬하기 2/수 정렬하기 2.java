import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge(int left, int right) {
        int mid = (left + right) / 2;
        int idx1 = left;
        int idx2 = mid;
        for (int i = left; i < right; i++) {
            if (idx1 == mid) {
                temp[i] = arr[idx2++];
            } else if (idx2 == right) {
                temp[i] = arr[idx1++];
            } else if (arr[idx1] <= arr[idx2]) {
                temp[i] = arr[idx1++];
            } else {
                temp[i] = arr[idx2++];
            }
        }
        for (int i = left; i < right; i++) {
            arr[i] = temp[i];
        }
    }

    public static void mergeSort(int left, int right) {
        if (left+1 >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid, right);
        merge(left, right);
    }
}
