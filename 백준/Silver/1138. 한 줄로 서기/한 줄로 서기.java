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
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            int higher = -1;
            for (int j = 1; j <= n; j++) {
                if (arr[j] == 0) {
                    higher++;
                }
                if (higher == val) {
                    arr[j] = i;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
