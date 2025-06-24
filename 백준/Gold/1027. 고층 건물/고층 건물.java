import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, check(i));
        }
        System.out.println(max);
    }

    public static int check(int curr) {
        int count = 0;
        double temp = 0;

        for (int i = curr - 1; i > 0; i--) {
            double incline = (double) (arr[curr] - arr[i]) / (curr - i);
            if (i == curr - 1 || incline < temp) {
                temp = incline;
                count++;
            }
        }

        for (int i = curr + 1; i < n + 1; i++) {
            double incline = (double) (arr[curr] - arr[i]) /(curr - i);
            if (i == curr + 1 || incline > temp) {
                temp = incline;
                count++;
            }
        }

        return count;
    }
}
