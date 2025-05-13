import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int startIdx = 0;
        int endIdx = 0;
        int answer = 0;
        while (endIdx < n) {
            while (endIdx < n && count[arr[endIdx]] + 1 <= k) {
                count[arr[endIdx]]++;   
                endIdx++;   
            }
            answer = Math.max(answer, endIdx - startIdx);
            count[arr[startIdx]]--; 
            startIdx++; 
        }

        System.out.println(answer);
    }
}
