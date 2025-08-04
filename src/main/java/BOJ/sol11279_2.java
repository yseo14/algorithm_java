package BOJ;

import java.io.*;
import java.util.*;

public class sol11279_2 {
    static int n;
    static int[] heap;
    static int size = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        heap = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                insert(x);
            } else {
                sb.append(delete()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void insert(int x) {
        heap[++size] = x;   //  제일 마지막에 값을 넣음
        int idx = size;
        while (idx > 1 && heap[idx] > heap[idx / 2]) {  //  부모보다 더 크면 swap
            swap(heap[idx], heap[idx / 2]);
            idx /= 2;
        }
    }

    public static int delete() {
        if (size == 0) {
            return 0;
        }

        int max = heap[1];  //  제일 위의 값 == 최댓값
        heap[1] = heap[size--]; //  제일 마지막에 있는 값을 첫번째에 올림
        heapify(1); //  첫번째에 들어간 값부터 제자리를 찾을 때까지 수행
        return max;
    }

    public static void heapify(int i) {
        int largest = i;
        int left = size * 2;
        int right = size * 2 + 1;

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) { //  현재 위치를 의미하는 i의 값이 제일 큰 값이 아니라면, 마저 아래로 내려보냄
            swap(largest, i);
            heapify(largest);   //  재귀적으로 수행하며 아래로 내려 보냄
        }
    }

    public static void swap(int a, int b) {
        int temp = heap[b];
        heap[b] = heap[a];
        heap[a] = temp;
    }
}