import java.io.*;
import java.util.*;

public class Main {
    static int n, k, p, x;
    static int[][] nums = {
            {1, 1, 1, 1, 1, 1, 0},  //  0
            {0, 1, 1, 0, 0, 0, 0},  //  1
            {1, 1, 0, 1, 1, 0, 1},  //  2
            {1, 1, 1, 1, 0, 0, 1},  //  3
            {0, 1, 1, 0, 0, 1, 1},  //  4
            {1, 0, 1, 1, 0, 1, 1},  //  5
            {1, 0, 1, 1, 1, 1, 1},  //  6
            {1, 1, 1, 0, 0, 0, 0},  //  7
            {1, 1, 1, 1, 1, 1, 1},  //  8
            {1, 1, 1, 1, 0, 1, 1}   //  9
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] curr = toDisplay(x);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int[] target = toDisplay(i);
            int required = 0;
            for (int j = 0; j < k; j++) {
                required += reverseCount(curr[j], target[j]);
            }
            if (required <= p) {
                answer++;
            }
        }
        System.out.println(answer - 1);
    }

    public static int reverseCount(int from, int to) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (nums[from][i] != nums[to][i]) {
                count++;
            }
        }
        return count;
    }

    public static int[] toDisplay(int floor) {
        int[] display = new int[k];
        for (int i = k - 1; i >= 0; i--) {  //  디스플레이에 현재 층 입력
            display[i] = floor % 10;
            floor /= 10;
        }
        return display;
    }
}
