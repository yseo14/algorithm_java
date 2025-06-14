import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[100001]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int end = 0;

        for (int start = 0; start < n; start++) {
            while (end < n && !visited[arr[end]]) {
                visited[arr[end]] = true;
                end++;
            }
            count += (end - start);
            visited[arr[start]] = false;
        }

        System.out.println(count);
    }
}
