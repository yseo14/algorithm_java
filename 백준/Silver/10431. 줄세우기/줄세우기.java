import java.io.*;
import java.util.*;

public class Main {
    static int p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= p; testCase++) {
            int[] arr = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        sum++;
                    }
                }
            }
            System.out.println(testCase + " " + sum);
        }

    }
}
